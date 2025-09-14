package com.example.cashcard.cashcard.repository;

import com.example.cashcard.cashcard.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
