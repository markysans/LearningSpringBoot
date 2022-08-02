package com.springtransaction.flightservice.repository;

import com.springtransaction.flightservice.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInformationRepository extends JpaRepository<PaymentInfo, String> {
}
