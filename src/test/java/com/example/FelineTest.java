package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittensWithoutParamsReturnsOne() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void getKittensWithParamsReturnsCorrectNumber() {
        int kittens = feline.getKittens(5);
        assertEquals(5, kittens);
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }
}
