public class Product{

    private String name;
    private int inventory;
    private double cost;

    public Product(String name, int inventory, double cost){
        this.name = name;
        this.inventory = inventory;
        this.cost = cost;
    }

    public void refund(int numPurchaseProduct){
        this.inventory = this.inventory + numPurchaseProduct;
    }

    public void puchase(int numPurchaseProduct){
        this.inventory = this.inventory - numPurchaseProduct;
    }

    public boolean canPurchase(int desireAmount){
        return desireAmount <= this.inventory; 
    }

    public String getName(){
        return name;
    }

    public int getInventory(){
        return inventory;
    }

    public double getCost(){
        return cost;
    }


}
