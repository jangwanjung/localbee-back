package project.localbee.domain.travel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.localbee.config.auth.LoginUserAnnotation;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.travel.dto.TravelSliceResDto;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.travel.service.TravelService;

import java.util.Map;


@RequiredArgsConstructor
@RestController
public class TravelController {

    private final TravelService travelService;

    @GetMapping("/api/travel/list")
    public TravelSliceResDto<Slice<?>> travelList(@LoginUserAnnotation LoginUser loginUser, Pageable pageable) {
        return travelService.travelListSearch(pageable);
    }

    @GetMapping("/api/travel/detail/{id}")
    public Travel travelDetail(@PathVariable("id") Long id) {
        System.out.println(id);
        return travelService.travelDetailSearch(id);
    }
}
