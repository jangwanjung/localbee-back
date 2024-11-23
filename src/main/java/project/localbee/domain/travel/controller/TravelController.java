package project.localbee.domain.travel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import project.localbee.config.auth.LoginUserAnnotation;
import project.localbee.config.dto.LoginUser;
import project.localbee.domain.travel.dto.TravelSliceResDto;
import project.localbee.domain.travel.entity.Travel;
import project.localbee.domain.travel.service.TravelService;

import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TravelController {

    private final TravelService travelService;

    @GetMapping("/travel/list")
    public TravelSliceResDto<Slice<?>> travelList(@LoginUserAnnotation LoginUser loginUser, Pageable pageable) {
        return travelService.travelListSearch(pageable);
    }

    @GetMapping("/travel/{id}")
    public Travel travelDetail(@PathVariable("id") Long id) {
        System.out.println(id);
        return travelService.travelDetailSearch(id);
    }
}
