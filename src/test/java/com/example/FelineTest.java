package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
class FelineTest {

    Feline feline;

    @BeforeEach
    public void init() {
        feline = new Feline();
    }

    @Test
    void eatMeatTrueFelineShowsTrue() {
        try {
//            Feline feline = new Feline();
            List<String> list = List.of("Животные", "Птицы", "Рыба");
            List<String> answer = feline.eatMeat();
            assertEquals(list, answer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getFamilyTrueFelineShowsTrue() {
//        Feline feline = new Feline();
        String answer = feline.getFamily();
        assertEquals("Кошачьи", answer);
    }

    @Test
    void getKittensTrueFelineShowsTrue() {
//        Feline feline = new Feline();
        int answer = feline.getKittens();
        assertEquals(1, answer);
    }

    @ParameterizedTest(name = "Проверка метода получения количества котят")
    @ValueSource(ints = {1, 3, 6})
    void getKittensCount5ShowsTrue(int count) {
//        Feline feline = new Feline();
        int answer = feline.getKittens(count);
        assertEquals(count, answer);
    }
}