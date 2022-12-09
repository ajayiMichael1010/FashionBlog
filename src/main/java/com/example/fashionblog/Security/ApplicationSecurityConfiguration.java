//package com.example.decagon.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.BlogUser;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class ApplicationSecurityConfiguration extends WebSec{
//    private  final PasswordEncoder passwordEncoder;
//    @Autowired
//    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       http
//               .authorizeRequests()
//               .antMatchers("/","index","/css/*","/js/*")
//               .permitAll()
//               .anyRequest()
//               .authenticated()
//               .and()
//               .httpBasic();
//    }
//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService(){
//        UserDetails michael= BlogUser.builder()
//                .username("olamic1")
//                .password(passwordEncoder.encode("1234"))
//                .roles("admin")
//                .build();
//        return  new InMemoryUserDetailsManager(
//                michael
//        );
//    }
//}
