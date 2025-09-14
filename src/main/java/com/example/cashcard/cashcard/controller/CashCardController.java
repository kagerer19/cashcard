package com.example.cashcard.cashcard.controller;

import com.example.cashcard.cashcard.model.Card;
import com.example.cashcard.cashcard.repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
class CashCardController {

    private final CardRepository cardRepository;

    CashCardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @PostMapping
    private ResponseEntity<Void> createCard(@RequestBody Card newCardRequest, UriComponentsBuilder ucb){
        Card savedCard = cardRepository.save(newCardRequest);
        URI locationOfCard = ucb
                .path("cashcard/{id}")
                .buildAndExpand(savedCard.getCardId())
                .toUri();
        return ResponseEntity.created(locationOfCard).build();
    }

    @GetMapping("/{requestedId}")
    private ResponseEntity<Card> findById(@PathVariable long requestedId) {
        Optional<Card> cardOptional = cardRepository.findById(requestedId);

        if(cardOptional.isPresent()){
            return ResponseEntity.ok(cardOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cards")
    private Iterable<Card> findAllCards() {
        return this.cardRepository.findAll();
    }
}
