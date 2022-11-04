package com.example.appclinica.controller;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.response.Response;
import com.example.appclinica.response.UsuarioTiposResponse;
import com.example.appclinica.security.ETipo;
import com.example.appclinica.security.Usuario;
import com.example.appclinica.service.UsuarioService;
import com.example.appclinica.service.util.JsonHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*", maxAge = 3600)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(tags = "Usuários")
public class UsuarioController {
	private final ObjectMapper objectMapper;
	private final UsuarioService usuarioService;

	public UsuarioController(ObjectMapper objectMapper, UsuarioService usuarioService) {
		this.objectMapper = objectMapper;
		this.usuarioService = usuarioService;
	}

	@PostMapping("/listar")
	@ApiOperation(value = "Retorna a lista de usuários")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Usuario>> listar(@RequestBody String query) {
		return ResponseEntity.ok(usuarioService.pesquisar(JsonHelper.fromJson(objectMapper, query, String.class)));
	}

	@GetMapping("/buscar/{id}")
	@ApiOperation(value = "Retorna os detalhes do usuário")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response<UsuarioTiposResponse>> buscar(@PathVariable("id") Long id) {
		try {
			Pair<Usuario, List<ETipo>> consulta = usuarioService.buscar(id);
			return ResponseEntity.ok(new Response<>(new UsuarioTiposResponse(consulta.getFirst(), consulta.getSecond().stream().map(Enum::name).toList()),
					Response.MSG_SUCCESS));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}

	@PostMapping("/salvar")
	@ApiOperation(value = "Cria ou atualiza o cadastro")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Response<UsuarioTiposResponse>> salvar(@RequestBody UsuarioTiposResponse usuarioTipos) {
		try {
			Pair<Usuario, List<ETipo>> result = usuarioService.salvar(usuarioTipos.getUsuario(),
					usuarioTipos.getTipos().stream().map(ETipo::valueOf).toList());
			return ResponseEntity.ok(new Response<>(new UsuarioTiposResponse(result.getFirst(),
					result.getSecond().stream().map(Enum::name).toList()),
					Response.MSG_SUCCESS));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}

	@PutMapping("/atualizar")
	@ApiOperation(value = "Atualiza cadastro do próprio usuário logado.")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Response<Usuario>> atualizar(@RequestBody Usuario usuario) {
		try {
			UserDetails userAuth = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Usuario usuarioP = usuarioService.buscar(userAuth.getUsername());
			if (Objects.equals(usuario.getId(), usuarioP.getId())) {
				return ResponseEntity.ok(new Response<>(usuarioService.salvar(usuario), Response.MSG_SUCCESS));
			} else {
				return ResponseEntity.badRequest().body(new Response<>("Não foi possível atualizar seu cadastro."));
			}
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
		}
	}
}