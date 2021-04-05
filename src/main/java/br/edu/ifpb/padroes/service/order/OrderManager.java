package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.states.InitialState;

public class OrderManager {

    public OrderManager(Order order) {
        this.order = order;
        this.orderState = new InitialState(this);
    }

    private Order order;

    private OrderState orderState;

    public void changeState(OrderState state) {
        this.orderState = state;
    }

    public OrderState getState() {
        return orderState;
    }

    public Order getOrder() {
        return order;
    }
}
