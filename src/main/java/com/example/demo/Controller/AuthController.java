package com.example.demo.Controller;


import com.example.demo.config.UserInfoDetailService;
import com.example.demo.entities.JwtRequest;
import com.example.demo.entities.JwtResponse;
import com.example.demo.entities.TokenData;
import com.example.demo.entities.User;
import com.example.demo.repo.TokenRepo;
import com.example.demo.servicesimp.UserServiceImpl;
import com.example.demo.utils.JWTUtility;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserInfoDetailService userInfoDetailService;
    @Autowired
    JWTUtility jwtUtility;
    @Autowired
    TokenRepo tokenRepo;

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user.getEmail());
        try {
            User existingUser = this.userService.getUserByEmailId(user.getEmail());
            if (existingUser != null) {
                return ResponseEntity.status(HttpStatus.OK).body("User Alreadey Exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.toString());
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("Registerd");
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getEmail(),
                            jwtRequest.getPassword()
                    )
            );

            if (authentication.isAuthenticated()) {
                UserDetails userDetails = userInfoDetailService.loadUserByUsername(jwtRequest.getEmail());
                String token = jwtUtility.generateToken(userDetails);
                this.tokenSaved(token);
                return ResponseEntity.ok(new JwtResponse(token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
            }
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + ex.getMessage());
        }
    }

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> tokenSaved(String tokenData){
        TokenData tokenData1 = new TokenData();
        tokenData1.setId(1);
        tokenData1.setData(tokenData);
        this.tokenRepo.save(tokenData1);
        return ResponseEntity.status(HttpStatus.OK).body("LoggedIn");
    }

    @DeleteMapping("/delete")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> deleteToken(){
        System.out.println("Delete token called");
        this.tokenRepo.deleteById(1);
        return ResponseEntity.status(HttpStatus.OK).body("LoggedOut");
    }

    @GetMapping("/isToken")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> getToken(){
        System.out.println("is Token Called");
        Optional<TokenData> tokenData = this.tokenRepo.findById(1);
        if(tokenData.isPresent()){
            TokenData tokenData1 = tokenData.get();
            return ResponseEntity.status(HttpStatus.OK).body(tokenData1.getData());
        }
        return ResponseEntity.status(HttpStatus.OK).body("null");
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        User existingUser = this.userService.getUserByEmail(user.getEmail());
//        if (existingUser != null) {
//            System.out.println(existingUser.getPassword().equals(user.getPassword()));
//            if (existingUser.getPassword().equals(user.getPassword())) {
//                return ResponseEntity.ok(existingUser);
//            } else {
//                return ResponseEntity.status(400).body("Password Incorrect");
//            }
//        }
//        return ResponseEntity.status(400).body("No User Found");
//    }

//    @GetMapping("/example")
//    public String exampleMethod(@AuthenticationPrincipal MyUserInfo principal) {
//        // Access principal details here
//        System.out.println(principal);
//        return "examplePage";
//    }


}
