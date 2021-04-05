package br.edu.ifpb.padroes.service.order.states;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.order.OrderState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class CanceledState extends OrderState {

    public CanceledState(OrderManager orderManager){
        super(orderManager);
        orderManager.getOrder().setStatus(Order.OrderStatus.CANCELED);
    }

    @Override
    public void payOrder(PaymentMethod paymentMethod) {
        System.out.println("Order canceled!");
    }

    @Override
    public void cancelOrder() {
        System.out.println("order already canceled!");
    }
}
