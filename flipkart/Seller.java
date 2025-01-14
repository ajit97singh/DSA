package src.src.flipkart;

class Seller {
    private static int id = 1;
    private final String name;
    private final int sellerId;
    private double profit = 0;
    public Seller(String name) {
        id++;
        this.name = name;
        this.sellerId = id;
    }

    public String getName() {
        return name;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void addProfit(double newProfit) {
        this.profit += newProfit;
    }
}
