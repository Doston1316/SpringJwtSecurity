package uz.doston.springjwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.doston.springjwtsecurity.model.AuthRequest;
import uz.doston.springjwtsecurity.model.User;
import uz.doston.springjwtsecurity.repository.UserRepository;
import uz.doston.springjwtsecurity.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserJwtController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/token")
    public ResponseEntity createToken(@RequestBody AuthRequest authRequest){
        User user=userRepository.findByUserName(authRequest.getUserName());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));

        }catch (Exception e){
            throw new IllegalStateException("Invalid username or password");
        }
        String token=jwtTokenProvider.createToken(user.getUserName(),user.getRoles());
        Map<Object,Object>map=new HashMap<>();
        map.put("username",user.getUserName());
        map.put("token",token);
        return ResponseEntity.ok(map);
    }

}
