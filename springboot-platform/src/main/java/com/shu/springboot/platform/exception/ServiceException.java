package com.shu.springboot.platform.exception;

import com.shu.springboot.platform.common.CodeMessage;
import lombok.Data;

/**
 * Created by shudongping on 2018/3/21 0021.
 */
@Data
public class ServiceException extends RuntimeException{

    private CodeMessage cm;

    public ServiceException(CodeMessage cm){
        super(cm.getMsg());
        this.cm = cm;
    }

}
