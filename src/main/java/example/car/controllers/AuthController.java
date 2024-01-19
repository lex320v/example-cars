package example.car.controllers;

import example.car.dto.auth.JwtResponseDto;
import example.car.dto.auth.SignInRequestDto;
import example.car.dto.auth.SignUpRequestDto;
import example.car.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/test")
    public String test() {
        return "is alive";
    }

    @Operation(summary = "Registration new user")
    @PostMapping("/sign-up")
    public JwtResponseDto signUp(@RequestBody @Valid SignUpRequestDto request) {
        return authService.signUp(request);
    }

    @Operation(summary = "Login")
    @PostMapping("/sign-in")
    public JwtResponseDto signIn(@RequestBody @Valid SignInRequestDto request) {
        return authService.signIn(request);
    }
}
