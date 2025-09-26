public class Main {

    protected String name;
    protected int price;
    protected int sold;
    protected int stock;

    public Main(String name, int price, int stock) {
     this.name = name;
     this.price = price;
     this.sold = 0;
     this.stock = stock;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getSold() { return sold; }
    public int getStock() { return stock; }

    public void details() {
        System.out.println("Item: " + name);
        System.out.println("Price:" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Sold: " + sold);

    }
}
