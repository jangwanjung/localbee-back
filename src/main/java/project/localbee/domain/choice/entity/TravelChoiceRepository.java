package project.localbee.domain.choice.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TravelChoiceRepository extends JpaRepository<Travel_choice,Long> {
    @Query("SELECT tc.type FROM Travel_choice tc WHERE tc.travel.id = :id")
    List<ChoiceType> findChoiceTypesByTravelId(@Param("id") Long id);
}
