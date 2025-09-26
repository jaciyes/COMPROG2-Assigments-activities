public class Jaci {
    protected  String name;
    protected int price;
    protected int stock;
    protected int sold;

    public Jaci(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = 0;
    }
    public void details() {
        System.out.println("\t---------------------------");
        System.out.println("\t Bayerische Motoren Werke ");
        System.out.println("\t---------------------------");
        System.out.println("item: " + name);
        System.out.println("price: $" + price);
        System.out.println("stock: " + stock);
        System.out.println("sold: " + sold);
    }
    public void buy() {
        if (stock > 0) {
            stock--;
            sold++;   
            System.out.println( " Successfully bought!"+name);
        } else {
            System.out.println("Cannot buy " + name + " Out of stock!");
        }
    }
    public void returnItem() {
        if (sold > 0) {
            sold--;
            stock++;
            System.out.println( " Successfully Return!"+name);
        } else {
            System.out.println("Cannot return " + name + "  None sold yet!");
        }
    }

 public static void main(String[] args) {
     Jaci item1 = new Jaci("Rolls-Royce La Rose Noire Droptail", 32000000, 3);
        item1.buy();
        item1.buy();
        item1.buy();
        item1.returnItem();
        item1.details();
     Jaci item2 = new Jaci("Rolls-Royce Boat Tail", 28000000, 3);
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
