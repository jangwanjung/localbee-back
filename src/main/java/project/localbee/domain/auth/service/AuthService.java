package project.localbee.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.auth.dto.SignUpReqDto;

import project.localbee.domain.user.entity.User;
import project.localbee.domain.user.entity.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public MessageResDto createUser(SignUpReqDto signUpReqDto) {
        boolean isUserExists = userRepository.findByEmail(signUpReqDto.getEmail()).isPresent();
        if (isUserExists) {
            return new MessageResDto("회원가입 실패");
        }
        String encPassword = bCryptPasswordEncoder.encode(signUpReqDto.getPassword());
        signUpReqDto.setPassword(encPassword);
        userRepository.save(signUpReqDto.toEntity());
        System.out.println(signUpReqDto);
        return new MessageResDto("회원가입 완료");
    }

    public MessageResDto checkUser(String email) {
        boolean isUserExists = userRepository.findByEmail(email).isPresent();
        if (isUserExists) {
            return new MessageResDto("중복 있음");
        }
        return new MessageResDto("중복 없음");
    }
}
