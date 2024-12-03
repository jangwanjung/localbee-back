package project.localbee.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.localbee.domain.booking.entity.ApprovalType;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingListResDto {

    private List<BookingDetail> bookingList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookingDetail {
        private Long id;
        private String title;
        private LocalDate time;
        private int participants;
        private String region;
        private ApprovalType approvalType;
        private Long guideId;
    }
}
