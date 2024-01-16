package example.car.controllers;

import example.car.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Tag(name = "User Controller")
@SecurityRequirement(name = "JWT")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String index(Principal principal) {
        System.out.println("#### " + principal);
        return "Hello, user!";
    }

    @GetMapping("/admin")
    public String exampleAdmin() {
        return "Hello, admin!";
    }

    @GetMapping("/get-admin")
    public void getAdmin() {
        userService.getAdmin();
    }
}
