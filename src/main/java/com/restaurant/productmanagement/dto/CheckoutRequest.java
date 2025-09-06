package com.restaurant.productmanagement.dto;

import com.restaurant.productmanagement.enums.PaymentMethod;
import lombok.Data;

@Data
public class CheckoutRequest {
    private PaymentMethod paymentMethod;
}
