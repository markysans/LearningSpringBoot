package com.springtransaction.flightservice.dto;

import com.springtransaction.flightservice.entity.PassengerInfo;
import com.springtransaction.flightservice.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
