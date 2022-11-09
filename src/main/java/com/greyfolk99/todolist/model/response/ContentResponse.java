package com.greyfolk99.todolist.model.response;

import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ContentResponse {
    private Long contentId;
    @Nullable
    private Integer orderNo;
    @Nullable
    private String context;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    @Builder
    public ContentResponse(Long contentId, Integer orderNo, String context) {
        this.contentId = contentId;
        this.orderNo = orderNo;
        this.context = context;
    }
}