package example.car.services;

import example.car.dto.auth.JwtResponseDTO;
import example.car.dto.auth.SignInRequestDTO;
import example.car.dto.auth.SignUpRequestDTO;
import example.car.models.Role;
import example.car.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtResponseDTO signUp(SignUpRequestDTO request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isActive(true)
                .role(Role.ROLE_USER)
                .build();
        userService.create(user);
        var jwt = jwtService.generateAccessToken(user.getUsername(), user.getRole().name());

        return new JwtResponseDTO(jwt, jwt);
    }

    public JwtResponseDTO signIn(SignInRequestDTO request) {
        User user = (User) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        )).getPrincipal();
        System.out.println(user);

        String jwt = jwtService.generateAccessToken(user.getUsername(), user.getRole().name());

        return new JwtResponseDTO(jwt, jwt);
    }
}
