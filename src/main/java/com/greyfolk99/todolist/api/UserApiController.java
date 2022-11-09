package com.greyfolk99.todolist.api;

import com.greyfolk99.todolist.exception.NoDataFoundException;
import com.greyfolk99.todolist.model.request.NewUserRequest;
import com.greyfolk99.todolist.model.response.UserResponse;
import com.greyfolk99.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    @PostMapping("/")
    public ResponseEntity<?> postNewUser(@RequestBody NewUserRequest request){
        UserResponse userResponse = userService.createUser(request);
        return userResponse.getUserId()!=null ?
                ResponseEntity.ok(userResponse) :
                ResponseEntity.status(HttpStatus.CONFLICT).body(false);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try { return ResponseEntity.ok(userService.searchUserByEmail(email)); }
        catch (NoDataFoundException e){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); }
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllUser(){
        List<UserResponse> userResponseList = userService.selectAllUsers();
        return userResponseList.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(false) :
                ResponseEntity.ok(userResponseList);
    }
}
