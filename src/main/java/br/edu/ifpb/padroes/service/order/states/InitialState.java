package br.edu.ifpb.padroes.service.order.states;

import br.edu.ifpb.padroes.service.event.EventPublish;
import br.edu.ifpb.padroes.service.event.Subscriber;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.log.LogTypes.LogFile;
import br.edu.ifpb.padroes.service.mail.EmailNotification;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.order.OrderState;
import br.edu.ifpb.padroes.service.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialState extends OrderState {
    public EventPublish eventPublish;

    public InitialState(OrderManager orderManager){
        super(orderManager);
        this.eventPublish = new EventPublish("payment", "paymentRefused", "canceled");
        List<Subscriber> subs = new ArrayList<>(
                Arrays.asList(
                        new EmailNotification(),
                        new LogService(new LogFile())
                )
        );
        this.eventPublish.subscribe("payment", subs);
        this.eventPublish.subscribe("paymentRefused", subs);
        this.eventPublish.subscribe("canceled", subs);
    }

    @Override
    public void payOrder(PaymentMethod paymentMethod) {
        this.orderManager.changeState(new InProgressState(this.orderManager));
        try {
            paymentMethod.doPayment();
            this.orderManager.changeState(new PaymentSuccessState(this.orderManager));
            this.eventPublish.notify(
                    "payment",
                    String.format("Order %d completed successfully", this.orderManager.getOrder().getId()),
                    null
            );
        } catch (Exception e) {
            this.orderManager.changeState(new PaymentRefusedState(this.orderManager));
            this.eventPublish.notify(
                    "paymentRefused",
                    String.format("Order %d refused", this.orderManager.getOrder().getId()),
                    null
            );
        }
    }

    @Override
    public void cancelOrder() {
        this.orderManager.changeState(new CanceledState(this.orderManager));
        this.eventPublish.notify(
                "canceled",
                String.format("Order %d canceled", this.orderManager.getOrder().getId()),
                null
        );

    }
}
