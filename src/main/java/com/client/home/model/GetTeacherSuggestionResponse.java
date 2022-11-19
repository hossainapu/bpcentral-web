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
public class GetTeacherSuggestionResponse extends ServiceResponse implements Serializable {

    List<SmallTeacher> suggestions;

    public GetTeacherSuggestionResponse(boolean status, String message) {
        super(status, message);
    }

    public GetTeacherSuggestionResponse(List<SmallTeacher> suggestions) {
        super();
        this.suggestions = suggestions;
    }
}
