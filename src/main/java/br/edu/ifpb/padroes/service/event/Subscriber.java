package br.edu.ifpb.padroes.service.event;

import br.edu.ifpb.padroes.domain.Customer;

public interface Subscriber {
    void update(String eventType, String message, Customer customer);
}
