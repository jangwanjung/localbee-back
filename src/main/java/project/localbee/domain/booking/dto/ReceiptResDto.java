package project.localbee.domain.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.localbee.domain.MessageResDto;
import project.localbee.domain.choice.entity.ChoiceType;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptResDto {

    private String tourGuide;
    private String client;
    private LocalDate date;
    private String location;
    private List<ChoiceType> included;
    private List<ChoiceType> notIncluded;
    private Long totalCost;


}
