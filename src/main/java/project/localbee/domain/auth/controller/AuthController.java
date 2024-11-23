package project.localbee.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.auth.dto.SignUpReqDto;

import project.localbee.domain.auth.service.AuthService;
import project.localbee.domain.user.service.UserService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/user")
    public MessageResDto signUp(SignUpReqDto signUpReqDto) {
        return authService.createUser(signUpReqDto);
    }
    @PostMapping("/user/check")
    public MessageResDto check(@RequestBody Map<String, String> email) {

        return authService.checkUser(email.get("email"));
    }
}
