package com.djsk.challenges.config;

//import com.djsk.challenges.security.CustomLogoutSuccessHandler;
import com.djsk.challenges.security.CustomLogoutSuccessHandler;
import com.djsk.challenges.security.LoginUserDetailsService;
//import com.djsk.challenges.security.MySavedRequestAwareAuthenticationSuccessHandler;
//import com.djsk.challenges.security.RestAuthenticationEntryPoint;
import com.djsk.challenges.security.MySavedRequestAwareAuthenticationSuccessHandler;
import com.djsk.challenges.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
//This annotation is used to enable work with @Pre... annotations and hasAuthority option
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan("com.djsk.challenges.security")
//@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginUserDetailsService userDetailsService;

    @Autowired
    private CustomLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authProvider());
// in memory authentication
//                auth.inMemoryAuthentication()
//                .withUser("memory@mem.eu").password("password").roles("VIEWER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                //Eliminates error from Cross-site request forgery ()
                .csrf().disable()
                .formLogin()
//                .defaultSuccessUrl("/main/webapp/WEB-INF/home.html")
                //
                .successHandler(authenticationSuccessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                //Developers should override this method when changing the instance of userDetailsServiceBean(). - from spring doc
                .userDetailsService(userDetailsService)
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutUrl("/logout");
    }

    //Problem with encrypt password - Spring Security, instead $2a$ should be $2b$
    //look at: https://github.com/spring-projects/spring-security/issues/3320#issuecomment-330402864
    //Class is used to generate BCrypt encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //An AuthenticationProvider implementation that retrieves user details from a UserDetailsService.
    //Needed for user authentication
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    //Is this needed?
//    @Bean
//    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
//        return new MySavedRequestAwareAuthenticationSuccessHandler();
//    }

}
