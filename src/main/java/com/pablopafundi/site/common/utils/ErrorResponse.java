package com.pablopafundi.site.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private Boolean success;
    private String message;
    private String errorCode;
    private LocalDateTime timestamp;


}
