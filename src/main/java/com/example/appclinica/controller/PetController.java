package com.example.appclinica.controller;

import com.example.appclinica.controller.model.TermoBuscaPet;
import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Pet;
import com.example.appclinica.response.Response;
import com.example.appclinica.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "*", maxAge = 3600)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(tags = "Pessoas")
public class PetController {

	private final ObjectMapper objectMapper;

	private final PetService petService;

	public PetController(ObjectMapper objectMapper, PetService petService) {
		this.objectMapper = objectMapper;
		this.petService = petService;
	}

	@PostMapping("/listar")
	@ApiOperation(value = "Busca tutores")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<Pet>> pesquisar(@RequestBody TermoBuscaPet busca) {
		return ResponseEntity.ok(petService.pesquisar(busca.getNome()));
	}

	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Retorna os detalhes do pet")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response<Pet>> buscar(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(new Response<>(petService.buscar(id), Response.MSG_SUCCESS));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}

	@PostMapping("/salvar")
	@ApiOperation(value = "Cria ou atualiza o cadastro")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Response<Pet>> salvar(@RequestBody Pet pet) {
		try {
			return ResponseEntity.ok(new Response<>(petService.salvar(pet), Response.MSG_SUCCESS));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}

	@DeleteMapping("/remover/{id}")
	@ApiOperation(value = "Remove o cadastro")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Response<Boolean>> remove(@PathVariable("id") Long id) {
		try {
			petService.remover(id);
			return ResponseEntity.ok(new Response<>(Boolean.TRUE, Response.MSG_SUCCESS));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}
}