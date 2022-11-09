package com.greyfolk99.todolist.mapper;

import com.greyfolk99.todolist.model.entity.Content;
import com.greyfolk99.todolist.model.request.NewContentRequest;
import com.greyfolk99.todolist.model.request.UpdateContentRequest;
import com.greyfolk99.todolist.model.response.ContentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);
    Content toCreate(NewContentRequest request);
    Content toUpdate(UpdateContentRequest request);
    ContentResponse toResponse(Content content);
}
