package project.localbee.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.localbee.config.dto.LoginUser;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.booking.entity.BookingRepository;
import project.localbee.domain.user.dto.BookingListResDto;
import project.localbee.domain.user.dto.ChangePasswordReqDto;
import project.localbee.domain.user.dto.SignUpReqDto;
import project.localbee.domain.user.dto.UserProfileResDto;
import project.localbee.domain.user.entity.User;
import project.localbee.domain.user.entity.UserRepository;
import project.localbee.domain.user.entity.VerificationRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final VerificationRepository verificationRepository;

    public UserProfileResDto userProfileSearch(Long id){
        return userRepository.findUserProfileById(id);
    }

    public BookingListResDto bookingPlannedListSearch(Long id){
        return new BookingListResDto(bookingRepository.findUpcomingBookings(id));
    }

    public BookingListResDto bookingCompletedListSearch(Long id){
        return new BookingListResDto(bookingRepository.findPastBookings(id));
    }

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

    public MessageResDto verifyPhoneCheck(String phoneNumber, String verificationCode) {
        if(!verificationRepository.findTopByPhoneNumberOrderByIdDesc(phoneNumber).getVerificationCode().equals(verificationCode)) {
            return new MessageResDto("전화번호 인증 확인 실패");
        }
        return new MessageResDto("전화번호 인증 확인 성공");
    }

    @Transactional
    public MessageResDto changePasswordRequest(ChangePasswordReqDto changePasswordReqDto, LoginUser loginUser) {
        if(!verificationRepository.findTopByPhoneNumberOrderByIdDesc(loginUser.getPhoneNumber()).getVerificationCode().equals(changePasswordReqDto.getVerificationCode())) {
            System.out.println(verificationRepository.findTopByPhoneNumberOrderByIdDesc(loginUser.getPhoneNumber()).getVerificationCode());
            System.out.println(changePasswordReqDto.getVerificationCode());
            return new MessageResDto("인증번호 일치하지않음");
        }
        User user = userRepository.findById(loginUser.getId()).orElseThrow(()->{
            return new RuntimeException("회원을 찾을수없음");
        });
        String newPassword = bCryptPasswordEncoder.encode(changePasswordReqDto.getNewPassword());
        user.setPassword(newPassword);
        return new MessageResDto("비밀번호 변경 완료");
    }

    public BookingListResDto bookingApplicationListSearch(Long id){
        return new BookingListResDto(bookingRepository.findApplicationBookings(id));
    }
}
