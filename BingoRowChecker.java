public class BingoRowChecker extends BingoChecker{
    int row;
    public BingoRowChecker(BingoCard bc, int row) {
        super(bc);
        this.row = row - 1;
    }

    @Override
    public void run() {
        int temp;
        for(int col = 0; col < 5; col++){

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

        System.out.println("\nCard: " + card.id + "\nROW: " + (row + 1) +" is done\n" + card);
        BingoGame.bingo_indetifier = true;
    }
}
