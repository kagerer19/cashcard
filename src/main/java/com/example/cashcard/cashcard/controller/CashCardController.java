package com.example.cashcard.cashcard.controller;

import com.example.cashcard.cashcard.model.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
class CashCardController {

    @GetMapping("/{requestedId}")
    private ResponseEntity<Card> findById(@PathVariable Long requestedId) {
        Card n26 = new Card();
        if (requestedId == 99L) {
            return ResponseEntity.ok(n26);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
