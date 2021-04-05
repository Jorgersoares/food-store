package br.edu.ifpb.padroes.service.event;

import br.edu.ifpb.padroes.domain.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPublish {
    Map<String, List<Subscriber>> listeners = new HashMap<>();

    public EventPublish(String... orderStatus) {
        for (String status: orderStatus){
            this.listeners.put(status, new ArrayList<>());
        }
    }

    public void subscribe(String event, List<Subscriber> subs){
        List<Subscriber> subscribers = listeners.get(event);
        subscribers.addAll(subs);
    }

    public void unsubscribe(String event, Subscriber subscriber){
        List<Subscriber> subscribers = listeners.get(event);
        subscribers.remove(subscriber);
    }

    public void notify(String event, String message, Customer customer){
        List<Subscriber> subscribers = listeners.get(event);
        for (Subscriber subscriber: subscribers){
            subscriber.update(event, message, customer);
        }
    }
}
