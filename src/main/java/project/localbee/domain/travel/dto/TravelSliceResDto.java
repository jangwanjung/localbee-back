package project.localbee.domain.travel.dto;

import lombok.Getter;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;

@Getter
public class TravelSliceResDto<T> {
    private List<T> content;
    private Sort sort;
    private int currentPage;
    private int size;
    private boolean first;
    private boolean last;

    public TravelSliceResDto(Slice<T> sliceContent){
        this.content=sliceContent.getContent();
        this.sort=sliceContent.getSort();
        this.currentPage=sliceContent.getNumber();
        this.size=sliceContent.getSize();
        this.first=sliceContent.isFirst();
        this.last=sliceContent.isLast();
    }

}
