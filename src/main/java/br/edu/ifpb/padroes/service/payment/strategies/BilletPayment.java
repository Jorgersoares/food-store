package br.edu.ifpb.padroes.service.payment.strategies;

import br.edu.ifpb.padroes.service.payment.PaymentMethod;

public class BilletPayment implements PaymentMethod {
    @Override
    public void doPayment() {
        System.out.println("Do billet payment!");
    }
}
