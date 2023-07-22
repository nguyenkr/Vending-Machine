import java.util.HashMap;

public class PurchaseDetails{

    private Database db;

    public PurchaseDetails(Database db){
        this.db = db;
    };

    public void purchase(Request request,  CreditCardInfo creditCardInfo, int transactinId){

        //validate CreditCardInfo
        //check if card is exp
        //check if card number is valid
        //check if cvc is correct

        HashMap<String, Product> productDb = db.getProductDb();

        if(validateTransaction(request, productDb)){
            HashMap<String, Integer>  purchaseItems = createProductConsume(request);
            double totalCost = calculateCostOfTotalPurchase(purchaseItems, productDb);
            Transaction newTransaction = new Transaction(transactinId, totalCost, purchaseItems, creditCardInfo);

            completeTransaction(purchaseItems, productDb);
            //remove money from credit card
            db.addTranactionDb(transactinId, newTransaction);

        }else {
            //should throw an expection
            System.out.print("There isn't enough of the product to fullfill this order");
        }
     }

    private void completeTransaction(HashMap<String, Integer>  purchaseItems, HashMap<String, Product> productDb){
        for(String productName: purchaseItems.keySet()){
            Product productDetails = productDb.get(productName);
            productDetails.puchase(purchaseItems.get(productName));
        }
    }

    private double calculateCostOfTotalPurchase( HashMap<String, Integer> purchaseItems, HashMap<String, Product> productDb){
        double total = 0.0;
        
        for(String productName: purchaseItems.keySet()){
            int numProductPurchase = purchaseItems.get(productName);
            Product productDetails = productDb.get(productName);
            total = total + (numProductPurchase * productDetails.getCost());
        }
        return total;
    } 

    private HashMap<String, Integer> createProductConsume(Request request){
        HashMap<String, Integer> purchaseItems = new HashMap<String, Integer>();
        purchaseItems.put(API.SODA_STRING, request.getSoda());
        purchaseItems.put(API.CANDY_BAR_STRING, request.getCandyBar());
        purchaseItems.put(API.CHIPS_STRING, request.getChips());
        return purchaseItems;
    } 
    
    private boolean validateTransaction(Request request,  HashMap<String, Product> productDb){
        return (productDb.get(API.SODA_STRING).canPurchase(request.getSoda()) && 
                productDb.get(API.CANDY_BAR_STRING).canPurchase(request.getCandyBar()) &&
                productDb.get(API.CHIPS_STRING).canPurchase(request.getChips()));
    }
        
}
