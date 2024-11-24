package project.localbee.domain.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.booking.dto.BookingSubmitReqDto;
import project.localbee.domain.booking.entity.ApprovalType;
import project.localbee.domain.booking.entity.Booking;
import project.localbee.domain.booking.entity.BookingRepository;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.travel.entity.TravelRepository;

@RequiredArgsConstructor
@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final TravelRepository travelRepository;

    public MessageResDto CreateBooking (Long id, BookingSubmitReqDto bookingSubmitReqDto, LoginUser loginUser) {
        Travel travel = travelRepository.findById(id).orElseThrow(()->{
            return new RuntimeException("상품을 검색할수 없습니다");
        });
        Booking booking = bookingSubmitReqDto.toEntity();
        booking.setTravel(travel);;
        booking.setPrice(travel.getPrice()*bookingSubmitReqDto.getParticipants());
        booking.setApproval_type(ApprovalType.APPROVED);
        booking.setUser(loginUser.getUser());
        bookingRepository.save(booking);

        return new MessageResDto("상품 신청 완료");
    }
}
