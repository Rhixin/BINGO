public abstract class BingoChecker implements Runnable{
    BingoCard card;

    public BingoChecker(BingoCard bc){
        card = bc;
    }

}
