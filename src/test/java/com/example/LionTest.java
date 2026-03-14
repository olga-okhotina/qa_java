package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void lionDoesHaveManeIfMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionDoesNotHaveManeIfFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionIfSexInvalid() throws Exception {
        new Lion("Неизвестно", feline);
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(4);

        Lion lion = new Lion("Самец", feline);

        int kittens = lion.getKittens();
        assertEquals(4, kittens);
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);

        Lion lion = new Lion("Самец", feline);

        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}
