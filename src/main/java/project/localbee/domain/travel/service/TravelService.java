package project.localbee.domain.travel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import project.localbee.domain.travel.dto.TravelListRespDto;
import project.localbee.domain.travel.dto.TravelSliceResDto;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.travel.entity.TravelRepository;


@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelSliceResDto travelListSearch (Pageable pageable) {
        Slice<TravelListRespDto> slice= travelRepository.findTravelList(pageable);
        return new TravelSliceResDto(slice);

    }

    public Travel travelDetailSearch (Long id) {
        return travelRepository.findById(id).orElse(null);
    }

    public Long travelPriceSearch (Long id) {
        return travelRepository.findById(id).get().getPrice();
    }
}
