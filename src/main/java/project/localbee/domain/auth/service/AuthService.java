package project.localbee.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.localbee.domain.auth.dto.CheckReqDto;
import project.localbee.domain.auth.dto.CheckResDto;
import project.localbee.domain.auth.dto.SignUpReqDto;
import project.localbee.domain.auth.dto.SignUpResDto;
import project.localbee.domain.user.entity.User;
import project.localbee.domain.user.entity.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public SignUpResDto createUser(SignUpReqDto signUpReqDto) {
        boolean isUserExists = userRepository.findByEmail(signUpReqDto.getEmail()).isPresent();
        if (isUserExists) {
            return new SignUpResDto("회원가입 실패");
        }
        String encPassword = bCryptPasswordEncoder.encode(signUpReqDto.getPassword());
        signUpReqDto.setPassword(encPassword);
        userRepository.save(signUpReqDto.toEntity());
        System.out.println(signUpReqDto);
        return new SignUpResDto("회원가입 완료");
    }

    public CheckResDto checkUser(CheckReqDto checkReqDto) {
        boolean isUserExists = userRepository.findByEmail(checkReqDto.getEmail()).isPresent();
        if (isUserExists) {
            return new CheckResDto("중복 있음");
        }
        return new CheckResDto("중복 없음");
    }
}
