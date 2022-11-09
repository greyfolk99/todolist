package com.greyfolk99.todolist.model.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateContentRequest {

    @NotBlank
    private Long contentId;
    private Integer orderNo;
    private String context;

    @Builder
    public UpdateContentRequest(Long contentId, Integer orderNo, String context) {
        this.contentId = contentId;
        this.orderNo = orderNo;
        this.context = context;
    }
}
