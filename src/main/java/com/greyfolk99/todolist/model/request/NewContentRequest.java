package com.greyfolk99.todolist.model.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewContentRequest {
    @NotBlank
    private Long toDoId;
    private Integer orderNo;
    private String context;

    @Builder
    public NewContentRequest(Long toDoId, Integer orderNo, String context) {
        this.toDoId = toDoId;
        this.orderNo = orderNo;
        this.context = context;
    }
}
