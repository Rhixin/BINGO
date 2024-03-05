public class Main {
    public static void main(String[] args) {
       BingoGame game = new BingoGame();
       Thread thrd = new Thread(game);
       thrd.start();
    }
}