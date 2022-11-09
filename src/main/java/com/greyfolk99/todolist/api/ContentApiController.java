package com.greyfolk99.todolist.api;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.model.request.NewContentRequest;
import com.greyfolk99.todolist.model.request.UpdateContentRequest;
import com.greyfolk99.todolist.model.response.ContentResponse;
import com.greyfolk99.todolist.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/content")
@RequiredArgsConstructor
public class ContentApiController {
    private final ContentService contentService;
    @PostMapping("/")
    public ResponseEntity<?> postNewContent(@RequestBody NewContentRequest request){
        ContentResponse contentResponse = contentService.createContent(request);
        return contentResponse!=null ?
                ResponseEntity.ok(contentResponse) :
                ResponseEntity.status(HttpStatus.CONFLICT).body(false);
    }
    @PutMapping("/")
    public ResponseEntity<?> putContent(@RequestBody UpdateContentRequest request){
        try { return ResponseEntity.ok(contentService.updateContent(request)); }
        catch (NoDataFoundException e){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); }
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllContent(@RequestParam Long toDoId){
        try { return ResponseEntity.ok(contentService.selectAllContent(toDoId)); }
        catch (NoDataFoundException e){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); }
    }
}
