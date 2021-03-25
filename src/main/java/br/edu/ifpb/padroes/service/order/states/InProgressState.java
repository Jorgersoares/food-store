package br.edu.ifpb.padroes.service.order.states;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.order.OrderState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class InProgressState extends OrderState {

    public InProgressState(OrderManager orderManager){
        super(orderManager);
        orderManager.getOrder().setStatus(Order.OrderStatus.IN_PROGRESS);
    }

    @Override
    public void payOrder(PaymentMethod paymentMethod) {
        System.out.println("Order in progress!");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order in progress!");
    }
}
