package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_LENGTH = 100;
    private static final int MAX_WIDTH = 100;
    private static final int MAX_PRICE = 1_000_000_000;

    private static final int DEALS_COUNT = 30;

    public static void main(String[] args) {
        final List<Deal> deals = generateDeals();

        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите цену за кв. метр");
            final int pricePerSquareMeter = scanner.nextInt();

            System.out.println("Честные сделки:");
            printDeals(deals, pricePerSquareMeter, (recommendedCost, declaredCost) -> recommendedCost >= declaredCost);

            System.out.println("Нечестные сделки:");
            printDeals(deals, pricePerSquareMeter, (recommendedCost, declaredCost) -> recommendedCost < declaredCost);
        }
    }

    private static List<Deal> generateDeals() {
        final Random random = new Random();
        final List<Deal> deals = new ArrayList<>();
        for (int i = 0; i < DEALS_COUNT; i++) {
            deals.add(new Deal(random.nextInt(MAX_LENGTH) + 1,
                    random.nextInt(MAX_WIDTH) + 1,
                    random.nextInt(MAX_PRICE) + 1)
            );
        }
        return deals;
    }

    private static void printDeals(List<Deal> deals, int pricePerSquareMeter, PricePredicate pricePredicate) {
        deals.stream()
                .filter(deal -> pricePredicate.checkPrice(deal.getArea() * pricePerSquareMeter, deal.getPrice()))
                .forEach(System.out::println);
    }
}
