package com.greyfolk99.todolist.api;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.model.request.NewToDoRequest;
import com.greyfolk99.todolist.model.request.UpdateToDoRequest;
import com.greyfolk99.todolist.model.response.ToDoResponse;
import com.greyfolk99.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoApiController {
    private final ToDoService toDoService;
    @PostMapping("/")
    public ResponseEntity<?> postNewToDo(@RequestBody NewToDoRequest request){
        ToDoResponse toDoResponse = toDoService.createToDo(request);
        return toDoResponse!=null ?
                ResponseEntity.ok(toDoResponse) :
                ResponseEntity.status(HttpStatus.CONFLICT).body(false);
    }
    @PutMapping("/")
    public ResponseEntity<?> putToDo(@RequestBody UpdateToDoRequest request){
        try { return ResponseEntity.ok(toDoService.updateToDo(request)); }
        catch (NoDataFoundException e){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); }
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllToDo(@RequestParam Long userId){
        List<ToDoResponse> ToDoResponseList = toDoService.selectAllToDoByUserId(userId);
        return ToDoResponseList.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(false) :
                ResponseEntity.ok(ToDoResponseList);
    }
}
