package fr.facil.facilapi.controller;

import fr.facil.facilapi.models.AuthRequest;
import fr.facil.facilapi.supplement.jwt;
import fr.facil.facilapi.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommunRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public jwt generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }catch(Exception e){
            throw  new Exception("invalid username/password");
        }

        jwt j = new jwt(jwtUtil.generateToken(authRequest));

        return j;
    }

}
