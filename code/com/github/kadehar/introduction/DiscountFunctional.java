package com.github.kadehar.introduction;

import java.math.BigDecimal;

import static com.github.kadehar.introduction.Prices.prices;

public class DiscountFunctional {
    /**
     * Filter prices greater than $20, map the prices to dis-
     * counted values, and then add them up. The code flows along with logic in the
     * same way we’d describe the requirements. As a convention in Java, we wrap
     * long lines of code and line up the dots before the method names.
     */
    public static void main(String[] args) {
        final BigDecimal totalOfDiscountedPrices =
                prices.stream()
                        .filter(price ->
                                price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price ->
                                price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
