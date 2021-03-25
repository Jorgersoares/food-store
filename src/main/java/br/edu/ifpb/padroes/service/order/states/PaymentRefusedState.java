package br.edu.ifpb.padroes.service.order.states;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.order.OrderState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class PaymentRefusedState extends OrderState {

    public PaymentRefusedState(OrderManager orderManager){
        super(orderManager);
        orderManager.getOrder().setStatus(Order.OrderStatus.PAYMENT_REFUSED);
    }
    @Override
    public void payOrder(PaymentMethod paymentMethod) {
        this.orderManager.changeState(new InitialState(this.orderManager));
        this.orderManager.getState().payOrder(paymentMethod);
    }

    @Override
    public void cancelOrder() {
        this.orderManager.changeState(new InitialState(this.orderManager));
        this.orderManager.getState().cancelOrder();
    }
}
