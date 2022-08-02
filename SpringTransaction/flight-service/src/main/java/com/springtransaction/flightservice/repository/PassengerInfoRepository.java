package com.springtransaction.flightservice.repository;

import com.springtransaction.flightservice.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
