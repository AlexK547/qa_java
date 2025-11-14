package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    Feline feline;

    @BeforeEach
    public void init() {
        feline = new Feline();
    }

    @Test
    void eatMeatTrueFelineShowsTrue() throws Exception {
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        List<String> answer = feline.eatMeat();
        assertEquals(list, answer);
    }

    @Test
    void getFamilyTrueFelineShowsTrue() {
        String answer = feline.getFamily();
        assertEquals("Кошачьи", answer);
    }

    @Test
    void getKittensTrueFelineShowsTrue() {
        int answer = feline.getKittens();
        assertEquals(1, answer);
    }

    @ParameterizedTest(name = "Проверка метода получения количества котят")
    @ValueSource(ints = {1, 3, 6})
    void getKittensCount5ShowsTrue(int count) {
        int answer = feline.getKittens(count);
        assertEquals(count, answer);
    }
}