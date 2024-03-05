import java.util.List;

public abstract class BingoPattern implements Runnable{
    List<BingoChecker> checkers;
    BingoCard card_to_check;

    BingoPattern(BingoCard card_to_check){
        this.card_to_check = card_to_check;
    }

}
