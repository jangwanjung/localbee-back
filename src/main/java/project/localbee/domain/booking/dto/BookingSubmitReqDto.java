package project.localbee.domain.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.localbee.domain.booking.entity.Booking;
import project.localbee.domain.choice.entity.Booking_choice;
import project.localbee.domain.choice.entity.ChoiceType;
import project.localbee.domain.user.entity.RoleType;
import project.localbee.domain.user.entity.User;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingSubmitReqDto {

    private LocalDate time;
    private String request;
    private int participants;
    private List<ChoiceType> choices;

    public Booking toEntity(){
        Booking booking = Booking.builder()
                .time(time)
                .request(request)
                .build();

        List<Booking_choice> bookingChoices = choices.stream()
                .map(choiceType -> {
                    // Booking_choice 생성 시 Booking 객체와 ChoiceType을 설정
                    Booking_choice bookingChoice = new Booking_choice();
                    bookingChoice.setBooking(booking);  // Booking 객체 설정
                    bookingChoice.setType(choiceType);  // ChoiceType 설정
                    return bookingChoice;
                })
                .collect(Collectors.toList());

        booking.setChoices(bookingChoices);
        return booking;
    }
}
