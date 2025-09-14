package com.example.cashcard.cashcard.controller;

import com.example.cashcard.cashcard.model.Card;
import com.example.cashcard.cashcard.repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
class CashCardController {

    private final CardRepository cardRepository;

    CashCardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/cards")
    private Iterable<Card> findAllCards() {
        return this.cardRepository.findAll();
    }
}
