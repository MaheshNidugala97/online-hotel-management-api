package com.sdp.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdp.hms.dao.RoleRepository;
import java.util.List;

import javax.validation.Valid;

import com.sdp.hms.dao.UserRepository;
import com.sdp.hms.dto.AuthResponseDto;
import com.sdp.hms.dto.LoginDto;
import com.sdp.hms.dto.MyDetailsResponseDto;
import com.sdp.hms.dto.RegistrationDto;
import com.sdp.hms.entity.Role;
import com.sdp.hms.entity.User;
import com.sdp.hms.exception.AccessDeniedException;
import com.sdp.hms.exception.ApiRequestException;
import com.sdp.hms.exception.InternalServerException;
import com.sdp.hms.security.JwtGenerator;

/**
 * 
 * @author mahesh nidugala
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hms/auth")
public class AuthenticationController {

	private UserRepository userRepository;

	private RoleRepository roleRepository;

	private AuthenticationManager authenticationManager;

	private PasswordEncoder passwordEncoder;

	private JwtGenerator jwtGenerator;

	public AuthenticationController(UserRepository userRepository, RoleRepository roleRepository,
			AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.jwtGenerator = jwtGenerator;
	}

	@PostMapping("signin")
	public ResponseEntity<AuthResponseDto> verifyUser(@RequestBody LoginDto loginDto) {
		try {

			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtGenerator.generateToken(authentication);
			return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
		} catch (Exception e) {
			throw new AccessDeniedException("Wrong credientials");
		}

	}

	@PostMapping("signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationDto registrationDto) {

		try {

			if (userRepository.existsByUsername(registrationDto.getUsername())) {
				throw new ApiRequestException(
						"User with username " + registrationDto.getUsername() + " already Exists");
			}

			if (userRepository.existsByEmail(registrationDto.getEmail())) {
				throw new ApiRequestException("User with email " + registrationDto.getEmail() + " already Exists");
			}

			User user = new User();
			user.setUsername(registrationDto.getUsername());
			user.setEmail(registrationDto.getEmail());
			user.setPhone(registrationDto.getPhone());
			user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

			Role roles = roleRepository.findByName("USER").get();
			user.setRoles(List.of(roles));

			userRepository.save(user);
			return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@GetMapping("me")
	public ResponseEntity<MyDetailsResponseDto> getMyDetails(@RequestHeader("Authorization") String token) {
		try {

			if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
				token = token.substring(7, token.length());
			}
			String email = jwtGenerator.getUsernameFromJWT(token);
			String role = jwtGenerator.getRoleFromJWT(token);
			return new ResponseEntity<>(new MyDetailsResponseDto(email, role), HttpStatus.OK);

		} catch (Exception e) {
			throw new AccessDeniedException("Wrong credientials");
		}

	}

}
