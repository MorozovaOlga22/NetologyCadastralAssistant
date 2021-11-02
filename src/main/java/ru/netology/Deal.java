package ru.netology;

public class Deal {
    private final int length;
    private final int width;
    private final int price;

    public Deal(int length, int width, int price) {
        this.length = length;
        this.width = width;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "length=" + length +
                ", width=" + width +
                ", price=" + price +
                '}';
    }
}
