package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline;

    @Test
    void getSoundAnswerMeowShowsTrue() {
        Cat cat = new Cat(feline);
        String answer = cat.getSound();
        assertEquals("Мяу", answer);
    }

    @Test
    void getFoodTrueCatShowsTrue() {
        Cat cat = new Cat(feline);

        try {
            cat.getFood();
            Mockito.verify(feline, Mockito.times(1)).eatMeat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}