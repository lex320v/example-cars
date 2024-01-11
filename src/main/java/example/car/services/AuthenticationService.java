package example.car.services;

import example.car.dto.auth.JwtAuthResponseDTO;
import example.car.dto.auth.SignInRequestDTO;
import example.car.dto.auth.SignUpRequestDTO;
import example.car.models.Role;
import example.car.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthenticationService(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthResponseDTO signUp(SignUpRequestDTO request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isActive(true)
                .role(Role.ROLE_USER)
                .build();
        userService.create(user);
        var jwt = jwtService.generateToken(user.getUsername());

        return new JwtAuthResponseDTO(jwt);
    }

    public JwtAuthResponseDTO signIn(SignInRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        ));

        var user = userService.userDetailsService().loadUserByUsername(request.getUsername());
        var jwt = jwtService.generateToken(user.getUsername());

        return new JwtAuthResponseDTO(jwt);
    }
}
