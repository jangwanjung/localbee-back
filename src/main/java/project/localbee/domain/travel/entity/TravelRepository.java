package project.localbee.domain.travel.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import project.localbee.domain.travel.dto.TravelListRespDto;


import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("SELECT new project.localbee.domain.travel.dto.TravelListRespDto(t.id, t.title, t.content, t.price,(SELECT i.image_url FROM Image i WHERE i.travel.id = t.id ORDER BY i.id ASC LIMIT 1)) FROM Travel t ORDER BY t.id DESC")
    Slice<TravelListRespDto> findTravelList(Pageable page);
}
