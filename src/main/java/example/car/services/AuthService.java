package example.car.services;

import example.car.dto.auth.JwtResponseDto;
import example.car.dto.auth.SignInRequestDto;
import example.car.dto.auth.SignUpRequestDto;
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

    public JwtResponseDto signUp(SignUpRequestDto request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isActive(true)
                .role(Role.ROLE_USER)
                .build();
        userService.create(user);
        var jwt = jwtService.generateAccessToken(user.getUsername(), user.getRole().name());

        return new JwtResponseDto(jwt, jwt);
    }

    public JwtResponseDto signIn(SignInRequestDto request) {
        User user = (User) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        )).getPrincipal();
        System.out.println(user);

        String jwt = jwtService.generateAccessToken(user.getUsername(), user.getRole().name());

        return new JwtResponseDto(jwt, jwt);
    }
}
