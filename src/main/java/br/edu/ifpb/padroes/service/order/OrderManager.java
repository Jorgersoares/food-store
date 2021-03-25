package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.EmailNotification;
import br.edu.ifpb.padroes.service.order.states.InitialState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class OrderManager {

    public OrderManager(Order order) {
        this.order = order;
        this.orderState = new InitialState(this);
    }

    private Order order;

    private OrderState orderState;

    private EmailNotification emailNotification = new EmailNotification();

    private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));

    public void changeState(OrderState state) {
        this.orderState = state;
    }

    public OrderState getState() {
        return orderState;
    }

    public Order getOrder() {
        return order;
    }

//    public void payOrder(PaymentMethod paymentMethod) {
//        order.setStatus(Order.OrderStatus.IN_PROGRESS);
//        try {
//            paymentMethod.doPayment();
//            order.setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
//            emailNotification.sendMailNotification(String.format("Order %d completed successfully", order.getId()));
//            logService.info("payment finished");
//        } catch (Exception e) {
//            logService.error("payment refused");
//            order.setStatus(Order.OrderStatus.PAYMENT_REFUSED);
//            emailNotification.sendMailNotification(String.format("Order %d refused", order.getId()));
//        }
//    }
//
//    public void cancelOrder() {
//        order.setStatus(Order.OrderStatus.CANCELED);
//        emailNotification.sendMailNotification(String.format("Order %d canceled", order.getId()));
//        logService.debug(String.format("order %d canceled", order.getId()));
//    }

}
