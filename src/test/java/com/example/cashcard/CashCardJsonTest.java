package com.example.cashcard;
import com.example.cashcard.cashcard.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
public class CashCardJsonTest {

    @Autowired
    private JacksonTester<Card> json;

    @Test
    void cashCardSerializationTest() throws IOException {
        Card cashCard = new Card(99L, 123.45, "EUR", LocalDate.of(2025, 12, 12));
        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.cardId");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.cardId").isEqualTo(99);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }

    @Test
    void cashCardDeserializationTest() throws IOException {
        String expected = """
                {
                    "cardId": "99",
                    "amount": "123.45",
                    "currency": "EUR",
                    "expirationDate": "2025-12-12"
                }
                """ ;
        //!TODO Adjust test to compare values not memory location. Or we can override equals function for Card class
        assertThat(json.parse(expected)).isEqualTo(new Card(99L, 123.45, "EUR", LocalDate.of(2025, 12, 12)));
        assertThat(json.parseObject(expected).getCardId()).isEqualTo(99);
        assertThat(json.parseObject(expected).getAmount()).isEqualTo(123.45);
    }
}