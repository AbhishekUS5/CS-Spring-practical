package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class APIResponse<T> {
    @JsonFormat(pattern = "hh:mm:ss dd-mm-yyy")
//    @Pattern(regexp = "hh-mm-ss-dd-mm-yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

   public APIResponse(){
       this.timeStamp = LocalDateTime.now();
   }

    public APIResponse(T data) {
       this();
       this.data = data;
    }

    public APIResponse(ApiError error) {
       this();
       this.error = error;
    }
}
