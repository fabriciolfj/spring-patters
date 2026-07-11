package com.github.fabriciolfj.patters.state;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrchestratorOrder {

    private final StateOrder initialState;

    public OrchestratorOrder(@Qualifier("statePending") final StateOrder initialState) {
        this.initialState = initialState;
    }

    public void process() {
        final OrderContext orderContext = new OrderContext(initialState);

        orderContext.execute();
        orderContext.execute();
    }

}
