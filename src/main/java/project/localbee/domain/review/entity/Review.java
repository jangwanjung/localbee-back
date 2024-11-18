package project.localbee.domain.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import project.localbee.domain.Like.entity.Like;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.user.entity.User;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "review")
    @JsonIgnoreProperties({"review"})
    private List<Like> likes;

    @CreationTimestamp
    private Timestamp created_at;

    @Transient
    private int like_count;
}
