package com.gpengtao.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by gpengtao on 15/3/24.
 */
public class SayHelloEvent extends ApplicationEvent {

    public SayHelloEvent(Object source) {
        super(source);
    }
}
