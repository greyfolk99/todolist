package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.model.entity.Content;
import com.greyfolk99.todolist.model.request.NewContentRequest;
import com.greyfolk99.todolist.model.request.UpdateContentRequest;
import com.greyfolk99.todolist.model.response.ContentResponse;

public interface ContentService {
    ContentResponse response(Content content);
    ContentResponse createContent(NewContentRequest request);
    ContentResponse updateContent(UpdateContentRequest request);
}
