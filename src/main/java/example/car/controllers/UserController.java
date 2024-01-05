package example.car.controllers;

import example.car.models.User;
import example.car.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/sign-up")
    public String signUp() {
        User user = new User();
        user.setEmail("example@mail.ru");
        user.setPassword("1111");
        user.setUsername("lex");
//        user.setIsActive(true);

        userRepository.save(user);

        return "index";
    }
}
