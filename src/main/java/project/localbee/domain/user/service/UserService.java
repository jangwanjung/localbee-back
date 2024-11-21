package project.localbee.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.localbee.domain.auth.dto.SignUpReqDto;
import project.localbee.domain.auth.dto.SignUpResDto;
import project.localbee.domain.user.dto.UserProfileResDto;
import project.localbee.domain.user.entity.User;
import project.localbee.domain.user.entity.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserProfileResDto userProfileSearch(Long id){
        return userRepository.findUserProfileById(id);
    }
}
