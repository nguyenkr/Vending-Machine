import java.util.HashMap;

public class API{
    public static final String SODA_STRING = "soda";
    public static final String CANDY_BAR_STRING = "candyBar";
    public static final String CHIPS_STRING = "chips";

    private Database db;
    private PurchaseDetails purchaseDetails;

    public API(Database db){
        this.db = db;
        this.purchaseDetails = new PurchaseDetails(db);
    };

    public void purchase(Request request,  CreditCardInfo creditCardInfo, int transactinId){
        purchaseDetails.purchase(request, creditCardInfo, transactinId);
     }

    public void refund(Request request,  int transactinId){ 

        //validate credit card still works
        //if not we will need to reach out to the consumer

        if(db.getTransactionById(transactinId) != null){
            HashMap<String, Product>productDb = db.getProductDb();
            Transaction refundTransaction = db.getTransactionById(transactinId);
            HashMap<String, Integer> productConsumed = refundTransaction.getProductConsume();
            
            for(String productName: productConsumed.keySet()){
                Product product = productDb.get(productName);
                product.refund(productConsumed.get(productName));
            }

            //return money to credit card
        }
    }

    public void getTrasactionById(int transactionId){
        Transaction transaction = db.getTransactionById(transactionId);

    }

    public void getTrasactions(){
        HashMap<Integer, Transaction> transactionDb = db.getTransactionDb();
    }

}
