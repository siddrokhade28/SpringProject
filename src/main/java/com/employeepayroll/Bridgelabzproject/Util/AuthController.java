package com.employeepayroll.Bridgelabzproject.Util;

import com.employeepayroll.Bridgelabzproject.Security.MyUserDetailsService;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthRequest;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @RequestMapping(value = "/authenticate" ,method = RequestMethod.POST)
    public ResponseEntity createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect Password and user name" ,e);
        }
        UserDetails userDetails= userDetailsService.loadUserByUsername(authRequest.getUsername());

        String jwt=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
