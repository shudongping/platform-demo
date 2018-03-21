package com.shu.springboot.platform.exception;

import com.shu.springboot.platform.common.CodeMessage;
import lombok.Data;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@Data
public class ServiceException extends RuntimeException{

    private CodeMessage cm;

    public ServiceException(CodeMessage cm){
        super(cm.getMsg());
        this.cm = cm;
    }

}
