package com.example.appclinica.controller;


import com.example.appclinica.controller.model.TermoBuscaTutor;
import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Tutor;
import com.example.appclinica.response.Response;
import com.example.appclinica.service.TutorService;
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
@RequestMapping("/api/tutor")
@CrossOrigin(origins = "*", maxAge = 3600)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(tags = "Tutores")
public class TutorController {

	private final ObjectMapper objectMapper;

	private final TutorService tutorService;

	public TutorController(ObjectMapper objectMapper, TutorService tutorService) {
		this.objectMapper = objectMapper;
		this.tutorService = tutorService;
	}

	@PostMapping("/listar")
	@ApiOperation(value = "Busca tutores")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<Tutor>> pesquisar(@RequestBody TermoBuscaTutor busca) {
		return ResponseEntity.ok(tutorService.pesquisar(busca.getNome()));
	}

	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Retorna os detalhes do tutor")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response<Tutor>> buscar(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(new Response<>(tutorService.buscar(id), Response.MSG_SUCCESS));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}

	@PostMapping("/salvar")
	@ApiOperation(value = "Cria ou atualiza o cadastro")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Response<Tutor>> salvar(@RequestBody Tutor tutor) {
		try {
			return ResponseEntity.ok(new Response<>(tutorService.salvar(tutor), Response.MSG_SUCCESS));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}

	@DeleteMapping("/remover/{id}")
	@ApiOperation(value = "Remove o cadastro")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Response<Boolean>> remove(@PathVariable("id") Long id) {
		try {
			tutorService.remover(id);
			return ResponseEntity.ok(new Response<>(Boolean.TRUE, Response.MSG_SUCCESS));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}
}