package com.rest.api.message;

import com.rest.api.cont.StatusEnum;
import lombok.Data;

@Data
public class Message {

    private StatusEnum status;
    private String message;
    private Object data;

    public Message(){
        this.status = StatusEnum.BAD_REQUEST;
        this.message = null;
        this.data = null;
    }

}
