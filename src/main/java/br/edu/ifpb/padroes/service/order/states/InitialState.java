package br.edu.ifpb.padroes.service.order.states;

import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.order.OrderState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class InitialState extends OrderState {

    public InitialState(OrderManager orderManager){
        super(orderManager);
    }

    @Override
    public void payOrder(PaymentMethod paymentMethod) {
        this.orderManager.changeState(new InProgressState(this.orderManager));
        try {
            paymentMethod.doPayment();
            this.orderManager.changeState(new PaymentSuccessState(this.orderManager));
//            emailNotification.sendMailNotification(String.format("Order %d completed successfully", order.getId()));
//            logService.info("payment finished");
        } catch (Exception e) {
//            logService.error("payment refused");
            this.orderManager.changeState(new PaymentRefusedState(this.orderManager));
//            emailNotification.sendMailNotification(String.format("Order %d refused", order.getId()));
        }
    }

    @Override
    public void cancelOrder() {
        this.orderManager.changeState(new InitialState(this.orderManager));
        this.orderManager.getState().cancelOrder();;
    }
}
