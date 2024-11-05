package inhatc.cse.yhjshope.config;

import inhatc.cse.yhjshope.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 기본 로그인 사용하기
        http.formLogin(form -> form
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/member/login/error")
                .permitAll()
        );
        http.logout(Customizer.withDefaults());

        http.authorizeHttpRequests(request -> request
                .requestMatchers("/","/member/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()

        );

        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}