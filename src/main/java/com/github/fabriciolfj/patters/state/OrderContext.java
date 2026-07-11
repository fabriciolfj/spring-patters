package com.github.fabriciolfj.patters.state;

/**
 * Mantem o estado corrente de um pedido especifico. Nao e um bean Spring:
 * como guarda estado mutavel por pedido, uma instancia deve ser criada
 * para cada pedido processado, nunca compartilhada como singleton.
 */
public class OrderContext {

    private StateOrder stateOrder;

    public OrderContext(final StateOrder initialState) {
        this.stateOrder = initialState;
    }

    public void execute() {
        this.stateOrder.execute(this);
    }

    public void setState(final StateOrder state) {
        this.stateOrder = state;
    }
}
