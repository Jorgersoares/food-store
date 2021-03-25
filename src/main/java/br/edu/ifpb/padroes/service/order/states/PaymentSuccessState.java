package br.edu.ifpb.padroes.service.order.states;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.order.OrderState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class PaymentSuccessState extends OrderState {

    public PaymentSuccessState(OrderManager orderManager){
        super(orderManager);
        orderManager.getOrder().setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
    }
    @Override
    public void payOrder(PaymentMethod paymentMethod) {
        System.out.println("Payment success!");
    }

    @Override
    public void cancelOrder() {
        this.orderManager.changeState(new InitialState(this.orderManager));
        this.orderManager.getState().cancelOrder();
    }
}
