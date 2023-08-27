package com.mymovieplan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
