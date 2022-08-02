package com.springtransaction.flightservice.utils;

import com.springtransaction.flightservice.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String, Double> paymentMap = new HashMap<>();
    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 8000.0);
        paymentMap.put("acc4", 9000.0);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if(paidAmount>paymentMap.get(accNo)) {
            throw new InsufficientAmountException("Insufficient Balance!");
        } else {
            return true;
        }
    }
}
