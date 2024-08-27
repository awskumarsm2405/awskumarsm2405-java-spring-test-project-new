package com.skm.account.controller;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skm.account.dto.LoginRequest;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(
		name="User Authentication Management",
		description= "Login and Register API for User Auth Management"
)
@RequestMapping("/api/auth")
public class CustomerController {
	
	@Autowired
	private JwtEncoder jwtEncoder;
	
	private final AuthenticationManager authenticationManager;

	public CustomerController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public JwtResponse login(@RequestBody LoginRequest loginRequest) {
		Authentication authenticationRequest =
				UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getName(), loginRequest.getPassword());
			Authentication authenticationResponse =
				this.authenticationManager.authenticate(authenticationRequest);
			return new JwtResponse(createToken(authenticationResponse));
	}

	private String createToken(Authentication authentication) {
		var claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(Instant.now())
				.expiresAt(Instant.now().plusSeconds(60 * 30))
				.subject(authentication.getName())
				.claim("scope", createScope(authentication))
				.build();

			return jwtEncoder.encode(JwtEncoderParameters.from(claims))
			.getTokenValue();
	}

	private Object createScope(Authentication authentication) {
		return authentication.getAuthorities().stream()
				.map(a -> a.getAuthority())
				.collect(Collectors.joining(" "));
	}
	

}
record JwtResponse(String token) {}
