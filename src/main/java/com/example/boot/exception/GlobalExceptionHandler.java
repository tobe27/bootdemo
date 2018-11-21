package com.example.boot.exception;

import com.example.boot.rest.model.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * WEB层统一异常处理-全局拦截异常后返回标准JSON格式
 * code = 400
 * message = e.getMessage()
 * @author Created by L.C.Y on 2018-11-20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截UserException后返回ResultBean
     * @param e 异常
     * @return ResultBean
     */
    @ExceptionHandler(value = UserException.class)
    public ResultBean responseUserException(Exception e) {
        UserException userException;
        if (e instanceof UserException) {
            userException = (UserException) e;
        } else {
            userException = new UserException("未知异常");
        }
        return new ResultBean().fail(userException.getMessage());
    }

}
