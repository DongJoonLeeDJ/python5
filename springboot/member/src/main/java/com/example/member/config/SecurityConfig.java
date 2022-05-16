package com.example.member.config;


import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // insert 회원가입할때 비번 인코딩
    // login select...

    @Autowired
    MemberRepository memberRepository;

    class UService implements UserDetailsService{
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            Member member = memberRepository.findByEmail(email);
            System.out.println("1234 : "+encoder.encode("1234"));
            return User.builder()
                    .username("aa@naver.com")
                    .password(encoder.encode("1234"))
                    .roles("USER")
                    .build();
        }
    }
    //alt + insert 키
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( (String email) -> {

//            System.out.println("email : "+email);
            Member member = memberRepository.findByEmail(email);
            System.out.println(member);
            if (member == null){
                throw new RuntimeException("해당되는 Email 없다");
            }
            return User.builder()
                    .username(member.getName())
                    .password(member.getPassword())
                    .roles("USER")
                    .build();
        }  ).passwordEncoder(passwordEncoder());
    }
    /*
    (String email) -> {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            Member member = memberRepository.findByEmail(email);
        System.out.println("1234 : "+encoder.encode("1234"));

        return User.builder()
                .username("aa@naver.com")
                .password(encoder.encode("1234"))
                .roles("USER")
                .build();
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();

        http.formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/user/login?error=pw")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/");

        /*
        접근 가능한 페이지
            1. /
            2. /user/**
            3. /member/**
        /member/insert.html
            thymeleaf -> security.jar
         */
        http.authorizeRequests()
                .antMatchers("/", "/user/**","/member/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }
}
