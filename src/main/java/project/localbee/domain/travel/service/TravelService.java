package project.localbee.domain.travel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import project.localbee.domain.travel.dto.TravelSliceResDto;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.travel.entity.TravelRepository;


@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelSliceResDto travelListSearch (Pageable pageable) {
        Slice<Travel> slice= travelRepository.findAllByOrderByIdDesc(pageable);
        return new TravelSliceResDto(slice);

    }
}
