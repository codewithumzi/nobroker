package com.nobroker.controller;

import com.nobroker.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private EmailVerificationService emailVerificationService;
    @PostMapping("/send-otp-for-login")
                 //http://localhost:8080/api/send-otp-for-login?email=codewithumzi@gmail.com
    public Map<String ,String > sendOtpForLogin(@RequestParam String email){
        return emailVerificationService.sendOtpForLogin (email);
    }
    @PostMapping("/verify-otp-for-login")
                //http://localhost:8080/api/verify-otp-for-login?email=codewithumzi@gmail.com&otp=012345
    public Map<String ,String>verifyOtpForLogin(@RequestParam String email,@RequestParam String otp){
        return emailVerificationService.verifyOtpForLogin(email,otp);
    }
}
