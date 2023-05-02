package hiag0liveira.github.io.upcar.config;


import hiag0liveira.github.io.upcar.domain.entity.PerfilTipo;
import hiag0liveira.github.io.upcar.service.UsuarioService;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    private static final String ADMIN = PerfilTipo.ADMIN.getDesc();
    private static final String VENDEDOR = PerfilTipo.VENDEDOR.getDesc();

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                        // acessos públicos liberados
                        .requestMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
                        .requestMatchers("/", "/home", "/expired").permitAll()
                        .requestMatchers("/u/p/**").permitAll()

                        // acessos privados admin
                        .requestMatchers("/u/novo/cadastro/usuario", "/u/lista").hasAuthority(ADMIN)

                         //Ambos tem
                        .requestMatchers("/u/editar/senha", "/u/confirmar/senha").hasAnyAuthority(ADMIN, VENDEDOR)
                        .requestMatchers("/agendamentos/**").hasAnyAuthority(ADMIN, VENDEDOR)
                        .requestMatchers("/clientes/**").hasAnyAuthority(ADMIN, VENDEDOR)
                        .requestMatchers("/carros/**").hasAnyAuthority(ADMIN, VENDEDOR)

                        // acessos privados vendedor
                        .requestMatchers("/vendedores/dados").hasAuthority(VENDEDOR)

                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/acesso-negado")
                .and()
                .rememberMe();

        http.sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/expired")
                .maxSessionsPreventsLogin(false)
                .sessionRegistry(sessionRegistry());

        http.sessionManagement()
                .sessionFixation()
                .newSession()
                .sessionAuthenticationStrategy(sessionAuthStrategy());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       PasswordEncoder passwordEncoder,
                                                       UsuarioService userDetailsService) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    public SessionAuthenticationStrategy sessionAuthStrategy() {
        return new RegisterSessionAuthenticationStrategy(sessionRegistry());
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public ServletListenerRegistrationBean<?> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>( new HttpSessionEventPublisher() );
    }
}
