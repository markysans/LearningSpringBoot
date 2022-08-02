package com.springtransaction.flightservice.service;

import com.springtransaction.flightservice.dto.FlightBookingAcknowledgement;
import com.springtransaction.flightservice.dto.FlightBookingRequest;
import com.springtransaction.flightservice.entity.PassengerInfo;
import com.springtransaction.flightservice.entity.PaymentInfo;
import com.springtransaction.flightservice.repository.PassengerInfoRepository;
import com.springtransaction.flightservice.repository.PaymentInformationRepository;
import com.springtransaction.flightservice.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    PassengerInfoRepository passengerInfoRepository;
    @Autowired
    PaymentInformationRepository paymentInformationRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest) {
        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfo=passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInformationRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("Success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}
