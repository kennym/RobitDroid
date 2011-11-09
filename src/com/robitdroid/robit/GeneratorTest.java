package com.robitdroid.robit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Author: Kenny Meyer <knny.myer@gmail.com>
 * Date: 11/9/11
 * Time: 4:08 PM
 */
public class GeneratorTest {
    private Generator generator;

    @Before
    public void setUp() throws Exception {
        this.generator = Generator.getInstance();
    }

    @Test
    public void testGenerateNumbersWhereRandom_bitEquals0() {
        this.generator.setRandom_bit(0);

        ArrayList numbers = this.generator.generateNumbers(9);
        ArrayList result = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                result.add(i);
            } else {
                result.add(0);
            }
        }

        assertEquals(numbers.size(), 9);
        assertEquals(numbers, result);
    }

    @Test
    public void testGenerateNumbersWhereRandom_bitEquals1() {
        this.generator.setRandom_bit(1);

        ArrayList numbers = this.generator.generateNumbers(9);
        ArrayList result = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) {
                result.add(i);
            } else {
                result.add(0);
            }
        }

        assertEquals(numbers.size(), 9);
        assertEquals(numbers, result);
    }
}
