package example.car.controllers;

import example.car.dto.JwtAuthResponseDTO;
import example.car.dto.SignInRequestDTO;
import example.car.dto.SignUpRequestDTO;
import example.car.exceptions.PersonNotRegistration;
import example.car.services.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping("/test")
    public String test() {
        return "is alive";
    }

    @PostMapping("/sign-up")
    public JwtAuthResponseDTO signUp(@RequestBody @Valid SignUpRequestDTO request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

            throw new PersonNotRegistration(errorMsg.toString());
        }

        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthResponseDTO signIn(@RequestBody @Valid SignInRequestDTO request) {
        return authenticationService.signIn(request);
    }

    @ExceptionHandler
    private ResponseEntity<Object> handleException(PersonNotRegistration e) {
        System.out.println("####??");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<Object> handleException(Exception e) {
        System.out.println("####");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
