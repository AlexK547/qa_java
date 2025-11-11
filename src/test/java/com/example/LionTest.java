package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;
    @Mock
    Lion lion;

    public void createLion(String sex) throws Exception {
        lion = new Lion(sex, feline);
    }

    @ParameterizedTest(name = "Проверка создания льва {0}")
    @ValueSource(strings = {"Не определено"})
    void createLionWithIncorrectNameThrowExeption(String sex) {
        try {
            assertThrows(
                    Exception.class,
                    () -> createLion(sex)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest(name = "Проверка метода получения количества котят у льва {0}")
    @ValueSource(strings = {"Самец", "Самка"})
    void getKittensTrueLionShowsTrue(String sex) {
        try {
            Lion lion = new Lion(sex, feline);
            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest(name = "Проверка наличия имени у льва {0}")
    @ValueSource(strings = {"Самец", "Самка"})
    void doesHaveManeTrueLionShowsTrue(String sex) {
        try {
            Lion lion = new Lion(sex, feline);
            boolean haveName = lion.doesHaveMane();
            if (sex.equals("Самец")) {
                assertTrue(haveName);
            }
            if (sex.equals("Самка")) {
                assertFalse(haveName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest(name = "Проверка метода получения перечня еды у льва {0}")
    @ValueSource(strings = {"Самец", "Самка"})
    void getFoodTrueLionShowsTrue(String sex) {
        try {
            Lion lion = new Lion(sex, feline);
            lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}