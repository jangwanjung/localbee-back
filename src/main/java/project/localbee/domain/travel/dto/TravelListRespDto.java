package project.localbee.domain.travel.dto;

import lombok.Getter;

@Getter
public class TravelListRespDto {

    private Long id;
    private String title;
    private String content;
    private Long price;
    private String imageUrl;

    public TravelListRespDto(Long id, String title, String content, Long price, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
