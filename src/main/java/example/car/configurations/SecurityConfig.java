//package example.car.configurations;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
////    private final CustomUserDetailsService customUserDetailsService;
////
////    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
////        this.customUserDetailsService = customUserDetailsService;
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                                .anyRequest().permitAll()
////                        .requestMatchers("/").permitAll()
////                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form.loginPage("/login").permitAll())
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
//
////    @Autowired
////    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
////    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(8);
//    }
//}