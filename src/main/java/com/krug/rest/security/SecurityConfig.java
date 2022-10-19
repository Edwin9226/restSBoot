package com.krug.rest.security;

import com.krug.rest.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Autowired
    private CustomUserDetailsService userDetailsService;

    //protected  void configure(AuthenticationManagerBuilder auth)throws Exception{
      //  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
   // }

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
        http.authorizeRequests().antMatchers("/api/authentication/**").permitAll()
                .anyRequest().authenticated();

       // jwt filter
        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
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
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }


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
