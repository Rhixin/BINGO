public class BingoColumnChecker extends BingoChecker{
    int col;

    public BingoColumnChecker(BingoCard bc, int col) {
        super(bc);
        this.col = col - 1;
    }

    @Override
    public void run() {
        int temp;
        for(int row = 0; row < 5; row++){

            temp = card.nums[row][col];

            while (!BingoGame.result[temp]){
                try {
                    synchronized (BingoGame.result){
                        BingoGame.result.wait();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("\nCard: " + card.id + "\nCOLUMN: " + (col + 1) + " is done\n" + card);
        BingoGame.bingo_indetifier = true;
    }
}
