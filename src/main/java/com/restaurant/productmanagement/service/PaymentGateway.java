
package com.restaurant.productmanagement.service;

import java.math.BigDecimal;

public interface PaymentGateway {
    String createPayment(BigDecimal amount, String description);
    boolean capture(String providerRef);
}
