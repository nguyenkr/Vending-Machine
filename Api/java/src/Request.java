public class Request{
    
    private int soda;
    private int candyBar;
    private int chips;

    public Request(int soda, int candyBar, int chips){
        this.soda = soda;
        this.candyBar = candyBar;
        this.chips = chips;
    }

    public int getSoda(){
        return this.soda;
    }

    public int getCandyBar(){
        return this.candyBar;
    }

    public int getChips(){
        return this.chips;
    }


}
