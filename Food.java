public class Food {

    String name;
    int price;

    Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    int priceFor(int quantity) {
        return price * quantity;
    }
}