import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Database db = new Database();
        HashMap<String, Product> productionDb = db.getProductDb();
        setUpProductDB(productionDb);

        for(String productName: productionDb.keySet()){
            Product product = productionDb.get(productName);
            System.out.println(product.getName() + "|   Inventory: " + product.getInventory() + "     Cost:" + product.getCost());
        }

    }

    public static void setUpProductDB(HashMap<String, Product> productDb){
        Product soda = new Product("soda", 5, .95);
        Product candyBar = new Product("candyBar", 5, .60);
        Product chips = new Product("chips", 5, .99);

        productDb.put("soda", soda);
        productDb.put("candyBar", candyBar);
        productDb.put("chips", chips);
    }

}
