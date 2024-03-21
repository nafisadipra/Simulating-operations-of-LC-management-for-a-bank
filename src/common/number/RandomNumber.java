package common.number;

import java.util.Random;

/**
 *
 * @author Muyeed
 */
public class RandomNumber {
    private final int numDigits;

    public RandomNumber(int numDigits) {
        this.numDigits = numDigits;
    }

    @Override
    public String toString() {
        return String.valueOf(generate());
    }
    
    public long generate() {
        long min = (long) Math.pow(10, numDigits - 1);
        long max = (long) Math.pow(10, numDigits);

        Random random = new Random();

        long randomNumber = min + (long)(random.nextDouble() * (max - min));

        return randomNumber;
    }
}
