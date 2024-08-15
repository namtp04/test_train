package nam.dev.test_training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.filter.RequestContextFilter;

//@EnableWebSecurity
//@Configuration
public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        PasswordEncoder password = passwordEncoder();
//        UserDetails user = User.builder()
//                .username("nam")
//                .password(password.encode("123"))
//                .roles("ADMIN")
//                .build();
//        // authen =>
//        // author => phan quyen
//        // token => 1-2 tuan
//        return new InMemoryUserDetailsManager(user);
//
//    }

//    @Bean
//    protected SecurityFilterChain webConfigure(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(
//                        req -> req
//                                .requestMatchers(HttpMethod.GET, "/api/category").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST, "/api/category").hasRole("ADMIN")
//                                .anyRequest().permitAll()
//                )
//                .formLogin(req -> req.loginProcessingUrl("/login"))
//        ;
//        return http.build();
//    }


}
