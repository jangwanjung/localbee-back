package project.localbee.domain.travel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import project.localbee.domain.choice.entity.Booking_choice;
import project.localbee.domain.choice.entity.Travel_choice;
import project.localbee.domain.review.entity.Review;
import project.localbee.domain.image.entity.Image;
import project.localbee.domain.schedule.entity.Schedule;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Long price;

    private String description;

    private String region;

    @OneToMany(mappedBy = "travel")
    @JsonIgnoreProperties({"travel"})
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "travel")
    @JsonIgnoreProperties({"travel"})
    private List<Review> reviews;

    @OneToMany(mappedBy = "travel")
    @JsonIgnoreProperties({"travel"})
    private List<Image> images;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"travel"})
    private List<Travel_choice> choices;


    @CreationTimestamp
    private Timestamp created_at;

}
