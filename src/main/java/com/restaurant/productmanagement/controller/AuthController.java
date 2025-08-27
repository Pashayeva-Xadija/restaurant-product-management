package com.restaurant.productmanagement.controller;



import com.restaurant.productmanagement.dto.AuthResponseDto;
import com.restaurant.productmanagement.dto.LoginDto;
import com.restaurant.productmanagement.dto.RegisterDto;
import com.restaurant.productmanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(authService.signup(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
