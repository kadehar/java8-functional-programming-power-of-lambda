package com.github.kadehar.introduction;

import java.math.BigDecimal;

import static com.github.kadehar.introduction.Prices.prices;

public class DiscountImperative {
    /**
     * We start with a mutable variable to hold the total of the
     * discounted prices. We then loop through the prices, pick each price greater
     * than $20, compute each item’s discounted value, and add those to the total.
     * Finally we print the total value of the discounted prices.
     */
    public static void main(String[] args) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPrices = totalOfDiscountedPrices
                        .add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
