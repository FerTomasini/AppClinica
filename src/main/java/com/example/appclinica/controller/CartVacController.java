package com.example.appclinica.controller;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.model.CartVac;
import com.example.appclinica.model.Historico;
import com.example.appclinica.repository.CartVacRepository;
import com.example.appclinica.response.Response;
import com.example.appclinica.service.CartVacService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/carteirinha")
@CrossOrigin(origins = "*", maxAge = 3600)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(tags = "CarteirinhaDeVacina")
public class CartVacController {

    private final ObjectMapper objectMapper;

    private final CartVacService cartVacService;

    private final CartVacRepository cartVacRepository;

    public CartVacController(ObjectMapper objectMapper, CartVacService cartVacService, CartVacRepository cartVacRepository) {
        this.objectMapper = objectMapper;
        this.cartVacService = cartVacService;
        this.cartVacRepository = cartVacRepository;
    }

    @GetMapping("/vacinas")
    /*@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")*/
    public ResponseEntity<List<CartVac>> getAllCarteirinhas() {
        try {
            List<CartVac> carterinhas = new ArrayList<CartVac>();
            cartVacRepository.findAll().forEach(carterinhas::add);
            if (carterinhas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(carterinhas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Retorna os detalhes da carteirinha")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Response<CartVac>> buscar(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(new Response<>(cartVacService.buscar(id), Response.MSG_SUCCESS));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(new Response<>(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
        }
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Cria ou atualiza a carteirinha")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response<CartVac>> salvar(@RequestBody CartVac cartaoVac) {
        try {
            return ResponseEntity.ok(new Response<>(cartVacService.salvar(cartaoVac), Response.MSG_SUCCESS));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new Response<>(e.getMessage()));
        }
    }
}
