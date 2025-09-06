// com.restaurant.productmanagement.serviceImpl.MockPaymentGateway
package com.restaurant.productmanagement.serviceImpl;

import com.restaurant.productmanagement.service.PaymentGateway;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class MockPaymentGateway implements PaymentGateway {
    @Override
    public String createPayment(BigDecimal amount, String description) {
        return "PAY-" + UUID.randomUUID();
    }
    @Override
    public boolean capture(String providerRef) { return true; }
}
