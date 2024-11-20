package project.localbee.domain.travel.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    Slice<Travel> findAllByOrderByIdDesc(Pageable page);
}
