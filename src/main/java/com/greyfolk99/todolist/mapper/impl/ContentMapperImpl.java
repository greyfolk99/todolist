package com.greyfolk99.todolist.mapper.impl;

import com.greyfolk99.todolist.mapper.ContentMapper;
import com.greyfolk99.todolist.model.entity.Content;
import com.greyfolk99.todolist.model.request.NewContentRequest;
import com.greyfolk99.todolist.model.request.UpdateContentRequest;
import com.greyfolk99.todolist.model.response.ContentResponse;

public class ContentMapperImpl implements ContentMapper {
    @Override
    public Content toCreate(NewContentRequest request) {
        return Content.builder()
                .context(request.getContext())
                .toDoId(request.getToDoId())
                .orderNo(request.getOrderNo())
                .build();
    }
    @Override
    public Content toUpdate(UpdateContentRequest request) {
        return Content.builder()
                .context(request.getContext())
                .contentId(request.getContentId())
                .orderNo(request.getOrderNo())
                .build();
    }
    @Override
    public ContentResponse toResponse(Content content) {
        return ContentResponse.builder()
                .contentId(content.getContentId())
                .orderNo(content.getOrderNo())
                .context(content.getContext())
                .build();
    }
}
