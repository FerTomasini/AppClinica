package com.example.appclinica.controller;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.Historico;
import com.example.appclinica.model.Pet;
import com.example.appclinica.model.Tutor;
import com.example.appclinica.repository.HistoricoRepository;
import com.example.appclinica.response.Response;
import com.example.appclinica.response.UsuarioTiposResponse;
import com.example.appclinica.security.ETipo;
import com.example.appclinica.security.Usuario;
import com.example.appclinica.service.HistoricoService;
import com.example.appclinica.service.util.JsonHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/historico")
@CrossOrigin(origins = "*", maxAge = 3600)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(tags = "Historicos")
public class HistoricoController {

    private final ObjectMapper objectMapper;

    private final HistoricoService historicoService;

    private final HistoricoRepository historicoRepository;

    public HistoricoController(ObjectMapper objectMapper, HistoricoService historicoService, HistoricoRepository historicoRepository) {
        this.objectMapper = objectMapper;
        this.historicoService = historicoService;
        this.historicoRepository = historicoRepository;
    }

    @GetMapping("/historicos")
    /*@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")*/
    public ResponseEntity<List<Historico>> getAllHist() {
        try {
            List<Historico> historicos = new ArrayList<Historico>();
            historicoRepository.findAll().forEach(historicos::add);
            if (historicos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(historicos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listar")
    @ApiOperation(value = "Retorna a lista de históricos")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Historico>> listar(@RequestBody String query) {
        return ResponseEntity.ok(historicoService.pesquisar(JsonHelper.fromJson(objectMapper, query, String.class)));
    }

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Retorna os detalhes do historico")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Response<Historico>> buscar(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(new Response<>(historicoService.buscar(id), Response.MSG_SUCCESS));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
        }
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Cria ou atualiza o historico")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response<Historico>> salvar(@RequestBody Historico historico) {
        try {
            return ResponseEntity.ok(new Response<>(historicoService.salvar(historico), Response.MSG_SUCCESS));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
        }
    }
}
