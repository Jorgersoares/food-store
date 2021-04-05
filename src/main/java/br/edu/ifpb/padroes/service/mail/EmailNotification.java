package br.edu.ifpb.padroes.service.mail;

import br.edu.ifpb.padroes.domain.Customer;
import br.edu.ifpb.padroes.service.event.Subscriber;

public class EmailNotification implements Subscriber {

    private final String emailAdministration = "contact@food-store.com";

    @Override
    public void update(String eventType, String message, Customer customer) {
        if (customer != null) {
            System.out.println("send mail notification to "+ customer.getEmail());
        } else {
            System.out.println("send mail notification to ="+emailAdministration);
        }
    }
}
