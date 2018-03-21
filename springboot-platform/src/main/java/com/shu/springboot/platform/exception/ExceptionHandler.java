package com.shu.springboot.platform.exception;

import com.shu.springboot.platform.common.CodeMessage;
import com.shu.springboot.platform.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
       if(e instanceof ServiceException){
            ServiceException serviceException = (ServiceException) e;
            return Result.error(serviceException.getCm());
       }else {
           return Result.error(CodeMessage.SERVER_ERROR);
       }
    }
}
