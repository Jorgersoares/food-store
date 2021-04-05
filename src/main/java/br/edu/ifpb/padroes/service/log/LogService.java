package br.edu.ifpb.padroes.service.log;

import br.edu.ifpb.padroes.domain.Customer;
import br.edu.ifpb.padroes.service.event.Subscriber;

public class LogService implements Subscriber {

    public LogService(Log logHandler) {
        this.logHandler = logHandler;
    }

    private Log logHandler;

    public void debug(String message) {
        logHandler.log("stack trace");
        logHandler.log(message);
    }

    public void info(String message) {
        logHandler.log(message);
    }
    public void error(String message) {
        logHandler.log("error");
        logHandler.log(message);
    }

    @Override
    public void update(String eventType, String message, Customer customer) {
        switch (eventType){
            case "payment":
                info(message);
                break;
            case "paymentRefused":
                error(message);
                break;
            case "canceled":
                debug(message);
            default:
                System.out.println("invalid event");
        }
    }
}
