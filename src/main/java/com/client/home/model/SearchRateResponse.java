package com.client.home.model;

import com.client.common.payload.ServiceResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchRateResponse extends ServiceResponse implements Serializable {

    List<SchoolData> dataList;
    Long totalCount;

    public SearchRateResponse(boolean status, String message) {
        super(status, message);
    }

    public SearchRateResponse(List<SchoolData> dataList, Long totalCount) {
        super();
        this.dataList = dataList;
        this.totalCount = totalCount;
    }
}
