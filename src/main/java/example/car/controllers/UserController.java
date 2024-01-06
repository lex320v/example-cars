package example.car.controllers;

import example.car.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody Object body) {
        System.out.println(body);
//        userService.createUser();

        return "index";
    }
}
