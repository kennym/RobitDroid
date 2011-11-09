package com.robitdroid.robit;

import java.util.ArrayList;

/**
 * Generator
 * <p/>
 * Provides the numbers for the game.
 * <p/>
 * Author: Kenny Meyer <knny.myer@gmail.com>
 * Date: 11/8/11
 * Time: 9:48 PM
 */
public class Generator {
    private static Generator _instance;

    private int random_bit;
    private int step_number;
    private int final_number;

    public static Generator getInstance() {
        if (_instance == null) {
            _instance = new Generator();
        }
        return _instance;
    }

    /**
     * Generate and return the numbers which will be displayed on the screen.
     *
     * @param limit - Number limit
     * @return ArrayList
     */
    public ArrayList<Integer> generateNumbers(int limit) {
        ArrayList numbers = new ArrayList();
        for (int j = 1; j <= limit; j++) {
            if (((j & 1 << this.step_number) <= 0) || (this.random_bit != 1)) {
                if (((j & 1 << this.step_number) != 0) || (this.random_bit == 1)) {
                    numbers.add(0);
                    continue;
                }
            }
            numbers.add(j);
        }

        return numbers;
    }

    /**
     * Get the value of the random_bit, to know which numbers are being displayed,
     * and then by knowing this number you know that when random_bit equals
     * 1, the number is in the list shown.
     * Therefore add the power of 2 by the step_number to the final result.
     */
    public void yes() {
        // The same instruction, just less readable (in my humble opinion):
        //this.final_number += ((this.random_bit == 0) ? 1 << this.step_number : 0);
        if (this.random_bit == 1) {
            this.final_number += (1 << this.step_number);
        }
        incrementStep();
    }

    /**
     * No, the number is not in the list.
     * <p/>
     * See the yes() method for documentation, because they're very similar.
     */
    public void no() {
        // The same instruction, just less readable (in my humble opinion):
        //this.final_number += ((this.random_bit == 0) ? 1 << this.step_number : 0);
        if (this.random_bit == 0) {
            this.final_number += (1 << this.step_number);
        }
        incrementStep();
    }

    /**
     * Reset the generator.
     * <p/>
     * Resetting the generator means:
     * <ul>
     * <li>Setting the instance.final_number to 0</li>
     * <li>Setting the instance.step_number to 0</li>
     * <li>Generate a new random bit</li>
     * </ul>
     */
    public void reset() {
        final_number = 0;
        setStep(0);
        genRandomBit();
    }

    /**
     * Set the private variable `step_number` to a specific value.
     *
     * @param n Set `step_number` to n.
     */
    public void setStep(int n) {
        this.step_number = n;
    }

    /**
     * Get the value of the private variable step_number.
     * <p/>
     * Obtener el valor de variable privada step_number.
     *
     * @return int
     */
    public int getStep() {
        return this.step_number;
    }

    /**
     * Increment `step_number` by one.
     * <p/>
     * Incrementar `step_number` por uno.
     */
    public void incrementStep() {
        this.step_number++;
    }

    public void genRandomBit() {
        this.random_bit = (int) (Math.random() * 2);
    }

    public void setRandom_bit(int val) {
        this.random_bit = val;
    }
}
