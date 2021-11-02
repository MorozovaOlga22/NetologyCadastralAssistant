package ru.netology;

@FunctionalInterface
public interface PricePredicate {
    boolean checkPrice(int recommendedCost, int declaredCost);
}
