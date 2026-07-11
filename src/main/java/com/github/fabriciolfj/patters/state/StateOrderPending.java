package com.github.fabriciolfj.patters.state;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component("statePending")
public class StateOrderPending implements StateOrder {

    private final StateOrder nextState;

    public StateOrderPending(@Qualifier("stateOrderProcess") final StateOrder nextState) {
        this.nextState = nextState;
    }

    @Override
    public void execute(final OrderContext context) {
        log.info("pending executed");
        context.setState(nextState);
    }
}
