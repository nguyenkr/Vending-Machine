import java.util.HashMap;

public class Transaction{

    private int id;
    private double total;
    private HashMap<String, Integer> productConsume;
    private CreditCardInfo creditCardInfo;


    public Transaction(int id, double total, HashMap<String, Integer> productConsume, CreditCardInfo creditCardInfo){
        this.id = id;
        this.total = total;
        this.productConsume = productConsume;
        this.creditCardInfo = creditCardInfo;
    }

    public int getId(){
        return id;
    }

    public double getTotal(){
        return this.total;
    }

    public HashMap<String, Integer> getProductConsume(){
        return this.productConsume;
    }

    public void addProductConsume(String productName, int numberProduct){
        this.productConsume.put(productName,numberProduct);
    }


}
