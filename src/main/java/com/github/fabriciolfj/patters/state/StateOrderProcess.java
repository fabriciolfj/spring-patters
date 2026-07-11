package com.github.fabriciolfj.patters.state;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("stateOrderProcess")
public class StateOrderProcess implements StateOrder{

    @Override
    public void execute(final OrderContext context) {
        log.info("process executed");
    }
}
