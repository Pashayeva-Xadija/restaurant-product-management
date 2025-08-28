package com.restaurant.productmanagement.controller;



import com.restaurant.productmanagement.dto.AuthResponseDto;
import com.restaurant.productmanagement.dto.LoginDto;
import com.restaurant.productmanagement.dto.RegisterDto;
import com.restaurant.productmanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDto> signupJson(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(authService.signup(dto));
    }


    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<AuthResponseDto> signupForm(RegisterDto dto) {
        return ResponseEntity.ok(authService.signup(dto));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDto> loginJson(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<AuthResponseDto> loginForm(LoginDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
