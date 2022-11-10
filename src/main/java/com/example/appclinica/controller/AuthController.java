package com.example.appclinica.controller;

import com.example.appclinica.response.AuthResponse;
import com.example.appclinica.security.UserAuth;
import com.example.appclinica.security.jwt.Utils;
import com.example.appclinica.security.request.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(tags = "Autorização")
public class AuthController {

	private final AuthenticationManager authManager;
	private final Utils Util;

	public AuthController(AuthenticationManager authManager, Utils Util) {
		this.authManager = authManager;
		this.Util = Util;
	}

	@PostMapping("/login")
	@ApiOperation(value = "Retorna o login do usuário")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = Util.generateJwtToken(authentication);

		UserAuth userAuth = (UserAuth) authentication.getPrincipal();
		List<String> tipos = userAuth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity.ok(new AuthResponse(jwt,
				userAuth.getId(),
				userAuth.getUsername(),
				tipos));
	}
}