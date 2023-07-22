import java.util.HashMap;

public class Database{

    private HashMap<String, Product> productDb;
    private HashMap<Integer, Transaction> transactionDb;

    public Database(){
        productDb = new HashMap<String, Product>();
        transactionDb = new HashMap<Integer, Transaction>();
    }

    public HashMap<String, Product> getProductDb(){
        return this.productDb;
    }

    public HashMap<Integer, Transaction> getTransactionDb(){
        return this.transactionDb;
    }

    public void addProductDb(String productName, Product product){
        productDb.put(productName, product);
    }

    public void addTranactionDb(Integer transactionId, Transaction transaction){
        transactionDb.put(transactionId, transaction);
    }

    public Product getProductByName(String productName){
        return productDb.get(productName);
    }

    public Transaction getTransactionById(Integer transactionId){
        return transactionDb.get(transactionId);
    }
}
