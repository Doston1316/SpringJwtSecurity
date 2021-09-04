package uz.doston.springjwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.doston.springjwtsecurity.model.User;
import uz.doston.springjwtsecurity.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user){
        if (userService.existByUsername(user.getUserName())){
            return new ResponseEntity("Ushbu foydalanuvchi oldin ro'yxatdan o'tgan", HttpStatus.BAD_REQUEST);
        }
        if (! checkpassword(user.getPassword())){
            return new ResponseEntity("Parol 4 tadan ko'p bo'lishi lozim",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(user));
    }





    private boolean checkpassword(String password) {
        return password.length()>4;
    }

}
