package com.example.appclinica.controller;

import com.example.appclinica.exception.ValidacaoException;
import com.example.appclinica.repository.UsuarioRepository;
import com.example.appclinica.repository.UsuarioTipoRepository;
import com.example.appclinica.response.Response;
import com.example.appclinica.response.UsuarioTiposResponse;
import com.example.appclinica.security.ETipo;
import com.example.appclinica.security.Usuario;
import com.example.appclinica.service.UsuarioService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static com.example.appclinica.service.util.JsonHelper.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioTipoRepository usuarioTipoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario logado;

    @BeforeAll
    public void init() throws ValidacaoException {
        logado = new Usuario("Fernanda",
                LocalDate.of(1988, 9, 16),
                "765.837.630-28",
                "fer@test.com",
                "(54) 99465-7846",
                "admin",
                "password");
        usuarioService.salvar(logado, List.of(ETipo.ROLE_ADMIN));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void cadastrarUsuario() throws Exception {
        mockmvc.perform(MockMvcRequestBuilders.post("/api/usuario/salvar")
                        .content(asJsonString(new UsuarioTiposResponse(new Usuario("Marco Antônio",
                                LocalDate.of(2009, 12, 22),
                                "370.162.350-33",
                                "marcola@gmail.com",
                                "(54) 9456-7123",
                                "marcola",
                                "12345678"),
                                List.of(ETipo.ROLE_USER.name()))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.object.usuario.id").value(logado.getId() + 1));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void listarUsuarios() throws Exception {
        mockmvc.perform(MockMvcRequestBuilders.post("/api/usuario/listar")
                        .content(asJsonString("bob"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(asJsonString(List.of(logado))));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void buscarUsuario() throws Exception {
        mockmvc.perform(MockMvcRequestBuilders.get("/api/usuario/buscar/{id}", logado.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(asJsonString(new Response<>(new UsuarioTiposResponse(logado,
                        List.of(ETipo.ROLE_ADMIN.name())),
                        Response.MSG_SUCCESS))));
    }

    @Test
    @WithMockUser(username = "admin", roles = { "ADMIN" })
    void atualizarUsuario() throws Exception {
        String nome = "Bob das Galaxias";
        logado.setNome(nome);
        mockmvc.perform(put("/api/usuario/atualizar")
                        .content(asJsonString(logado))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.object.id").value(logado.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.object.nome").value(nome));
    }

    @AfterAll
    public void cleanUp() {
        usuarioTipoRepository.deleteAll();
        usuarioRepository.deleteAll();
    }
}