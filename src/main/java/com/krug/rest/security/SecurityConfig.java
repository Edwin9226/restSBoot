package com.krug.rest.security;

import com.krug.rest.model.Rol;
import com.krug.rest.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {
    @Value("${authentication.internal-api-key}")
    private String internalApiKey;
    @Autowired
    private CustomUserDetailService userDetailsService;


    //protected  void configure(AuthenticationManagerBuilder auth)throws Exception{
    //  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    // }
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/api/authentication/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/poke/**").permitAll()
                .antMatchers("/api/poke/**").hasRole(Rol.ADMIN.name())
                .antMatchers("/api/internal/**").hasRole(Rol.SYSTEM_MANAGER.name())
                .anyRequest().authenticated();

        // jwt filter
        //internal > jwt >authentication
        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(internalApiAuthenticationFilter(), JwtAuthorizationFilter.class);
        return http.build();
    }

    @Bean
    public  InternalApiAuthentiocationFilter internalApiAuthenticationFilter()
    {
        return  new InternalApiAuthentiocationFilter(internalApiKey);
    }
    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter()
    {
        return  new JwtAuthorizationFilter();
    }

    //@Override
    //@Bean(BeanIds.AUTHENTICATION_MANAGER)
    //public AuthenticationManager authenticationManagerBean() throws Exception{
    //  return super.authenticationManagerBean();
    //}
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }


}
