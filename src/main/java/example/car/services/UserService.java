package example.car.services;

import example.car.models.User;
import example.car.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser() {
        User user = new User();
        user.setEmail("example@mail.ru");
        user.setPassword("1111");
        user.setUsername("lex");
        user.setIsActive(false);

        userRepository.save(user);
    }
}
