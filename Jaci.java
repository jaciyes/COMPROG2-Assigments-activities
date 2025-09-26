public class Jaci extends Main {
    public Jaci(String name, int price, int stock) {
    super(name, price, stock);
    }

    @Override
    public void details() {
    System.out.println("\t---------------------------");
    System.out.println("\t Bayerische Motoren Werke ");
    System.out.println("\t---------------------------");
        System.out.println("Item: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Sold: " + sold);
    System.out.println("/////////////////////////////////////////////////////");

    }

    public void buy() {
        if (stock > 0) {
            stock--;
            sold++;
            System.out.println(name + " bought successfully!");
        } else {
            System.out.println(" Cannot buy " + name + "Out of stock!");
        }
    }

    public void returnItem() {
        if (sold > 0) {
            stock++;
            sold--;
            System.out.println(name + "returned successfully!");
        } else {
            System.out.println(" Cannot return " + name + "None sold yet!");
        }
    }

    public static void main(String[] args) {
        Jaci item1 = new Jaci("Rolls-Royce La Rose Noire Droptail", 32000000, 3);
        item1.buy();
        item1.buy();
        item1.buy();
        item1.returnItem();
        item1.details();
        Jaci item2 = new Jaci("Rolls-Royce Boat Tail:", 28000000, 3);
        item2.buy();
        item2.buy();
        item2.returnItem();
        item2.returnItem();
        item2.details();
        Jaci item3 = new Jaci("SP Automotive Chaos", 14400000, 5);
        item3.returnItem();
        item3.returnItem();
        item3.returnItem();
        item3.details();
        Jaci item4 = new Jaci("Ferrari SF90 Stradale", 890000, 1);
        item4.buy();
        item4.buy();
        item4.details();
    }
}
