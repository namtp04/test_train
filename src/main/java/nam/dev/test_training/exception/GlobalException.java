package nam.dev.test_training.exception;

import lombok.extern.slf4j.Slf4j;
import nam.dev.test_training.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(value = AddException.class)
    ResponseEntity<ApiResponse> exception2(AddException addException){
        ErrorCode addCode = addException.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(addCode.getCode());
        apiResponse.setMessage(addCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> exception1(MethodArgumentNotValidException methodArgumentNotValid){
        String enumKey = methodArgumentNotValid.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.ENUM_KEY_WRONG;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }catch (IllegalArgumentException e){
            log.error("Lỗi: {}",enumKey);
        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

//    @ExceptionHandler(value = Exception.class)
//    ResponseEntity<ApiResponse> exception(Exception Exception){
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(ErrorCode.CATEGORY_EXISTED.getCode());
//        apiResponse.setMessage(ErrorCode.CATEGORY_EXISTED.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
}
