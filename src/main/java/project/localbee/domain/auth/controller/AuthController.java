package project.localbee.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.auth.dto.CheckReqDto;
import project.localbee.domain.auth.dto.SignUpReqDto;

import project.localbee.domain.auth.service.AuthService;
import project.localbee.domain.user.service.UserService;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/auth/signup")
    public MessageResDto signUp(SignUpReqDto signUpReqDto) {
        return authService.createUser(signUpReqDto);
    }
    @PostMapping("/api/auth/signup/check")
    public MessageResDto check(CheckReqDto checkReqDto) {
        System.out.println(checkReqDto);
        return authService.checkUser(checkReqDto);
    }
}
