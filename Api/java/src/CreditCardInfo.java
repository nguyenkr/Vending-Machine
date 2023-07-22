import java.util.Date;

public class CreditCardInfo{

    private int cardNumber;
    private Date expDate ;
    private int cvc;

    public CreditCardInfo(int cardNumber, Date expDate, int cvc){
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvc = cvc;
    }

    public int getCardNumber(){
        return this.cardNumber;
    }

    public Date getExpDate(){
        return this.expDate;
    }

    public int getCvc(){
        return this.cvc;
    }


}
