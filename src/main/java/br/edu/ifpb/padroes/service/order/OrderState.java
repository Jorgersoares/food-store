package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public abstract class OrderState {
    public OrderManager orderManager;

    public OrderState(OrderManager orderManager){
        this.orderManager = orderManager;
    }

    public abstract void payOrder(PaymentMethod paymentMethod);
    public abstract void cancelOrder();
}
