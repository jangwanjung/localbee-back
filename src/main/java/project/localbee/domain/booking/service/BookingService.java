package project.localbee.domain.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.booking.dto.BookingSubmitReqDto;
import project.localbee.domain.booking.dto.ReceiptResDto;
import project.localbee.domain.booking.entity.ApprovalType;
import project.localbee.domain.booking.entity.Booking;
import project.localbee.domain.booking.entity.BookingRepository;
import project.localbee.domain.choice.entity.BookingChoiceRepository;
import project.localbee.domain.choice.entity.ChoiceType;
import project.localbee.domain.choice.entity.TravelChoiceRepository;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.travel.entity.TravelRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final TravelRepository travelRepository;
    private final BookingChoiceRepository bookingChoiceRepository;
    private final TravelChoiceRepository travelChoiceRepository;

    public MessageResDto CreateBooking (Long id, BookingSubmitReqDto bookingSubmitReqDto, LoginUser loginUser) {
        Travel travel = travelRepository.findById(id).orElseThrow(()->{
            return new RuntimeException("상품을 검색할수 없습니다");
        });
        Booking booking = bookingSubmitReqDto.toEntity();
        booking.setTravel(travel);;
        booking.setPrice(travel.getPrice()*bookingSubmitReqDto.getPersonnel());
        booking.setApproval_type(ApprovalType.APPROVED);
        booking.setUser(loginUser.getUser());
        bookingRepository.save(booking);

        return new MessageResDto("상품 신청 완료");
    }

        public ReceiptResDto receiptSearch (Long id, LoginUser loginUser) {
            Booking booking = bookingRepository.findById(id).orElseThrow(()->{
                return new RuntimeException("영수증 찾기 실패");
            });
            if (booking.getUser().getId()!=loginUser.getUser().getId()) {
                System.out.println(booking.getUser());
                System.out.println(loginUser.getUser());
                throw new RuntimeException("권한 없음");
            }

            String tourGuide = booking.getTravel().getUser().getUsername();
            String client = booking.getUser().getUsername();
            LocalDate data = booking.getTime();
            String location = booking.getTravel().getRegion();
            List <ChoiceType> included =  bookingChoiceRepository.findChoiceTypesByBookingId(id);
            List <ChoiceType> allIncluded =  travelChoiceRepository.findChoiceTypesByTravelId(booking.getTravel().getId());
            List <ChoiceType> notIncluded = allIncluded.stream()
                    .filter(item -> !included.contains(item))
                    .toList();
            Long totalCost = booking.getPrice();

            return new ReceiptResDto(tourGuide,client,data,location,included,notIncluded,totalCost);

        }
}
