package project.localbee.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.localbee.domain.auth.dto.SignUpReqDto;
import project.localbee.domain.auth.dto.SignUpResDto;
import project.localbee.domain.user.service.UserService;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;

    @PostMapping("/auth/signup")
    public SignUpResDto signUp(SignUpReqDto signUpReqDto) {
        return userService.createUser(signUpReqDto);
    }
}
