package com.greyfolk99.todolist.service;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.mapper.ContentMapper;
import com.greyfolk99.todolist.model.entity.Content;
import com.greyfolk99.todolist.model.request.NewContentRequest;
import com.greyfolk99.todolist.model.request.UpdateContentRequest;
import com.greyfolk99.todolist.model.response.ContentResponse;
import com.greyfolk99.todolist.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService{

    private final Logger LOGGER = LogManager.getLogger(ContentService.class);
    private final ContentRepository contentRepository;

    @Override
    public ContentResponse response(Content content) {
        ContentResponse contentResponse = ContentMapper.INSTANCE.toResponse(content);
        LOGGER.info("[response] Map content -> ContentResponse : {}", contentResponse.toString());
        return contentResponse;
    }
    @Override
    public ContentResponse createContent(NewContentRequest request){
        Content content = ContentMapper.INSTANCE.toCreate(request);
        LOGGER.info("[createContent] Map NewContentRequest -> content : {}", content.toString());
        content = contentRepository.save(content);
        LOGGER.info("[createContent] Save content -> content : {}", content.toString());
        return response(content);
    }
    @Override
    public ContentResponse updateContent(UpdateContentRequest request){
        Content content = contentRepository.findById(request.getContentId()).orElseThrow(()->new NoDataFoundException("Bad Request : todo id was not found"));
        LOGGER.info("[updateContent] Find UpdateContentRequest.id -> content : {}", content.toString());
        content.updateAll(request);
        LOGGER.info("[updateContent] Update UpdateContentRequest -> content : {}", content.toString());
        content = contentRepository.save(content);
        LOGGER.info("[updateContent] Save content -> content : {}", content.toString());
        return response(content);
    }
}
