package com.example.cashcard.cashcard.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardId;

    private String amount;

    private String currency;

    private LocalDate expirationDate;

    public Card() {}

    public Card(Integer cardId, String amount, String currency, LocalDate expirationDate) {
        this.cardId = cardId;
        this.amount = amount;
        this.currency = currency;
        this.expirationDate = expirationDate;
    }

    public Integer getCardId() {
        return this.cardId;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }
}
