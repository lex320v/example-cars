package example.car.controllers;

import example.car.dto.auth.JwtResponseDTO;
import example.car.dto.auth.SignInRequestDTO;
import example.car.dto.auth.SignUpRequestDTO;
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
    public JwtResponseDTO signUp(@RequestBody @Valid SignUpRequestDTO request) {
        return authService.signUp(request);
    }

    @Operation(summary = "Login")
    @PostMapping("/sign-in")
    public JwtResponseDTO signIn(@RequestBody @Valid SignInRequestDTO request) {
        return authService.signIn(request);
    }
}
