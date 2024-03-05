import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoGame implements Runnable{

    List<BingoCard> cards;
    static boolean[] result = new boolean[76];

    static boolean bingo_indetifier = false;

    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many players? ");
        int cnt = sc.nextInt();

        cards = new ArrayList<>();

        for(int i = 0; i < cnt; i++){
            cards.add(new BingoCard(i+1));
        }

        for(BingoCard card: cards){
            System.out.println("Card " + card.id);
            System.out.println(card);
        }

        for(int i = 1; i < 76; i++){
            result[i] = false;
        }
        result[0] = true;




        Thread[] checkerRowThreads = new Thread[cnt];
        Thread[] checkerColThreads = new Thread[cnt];

        for(int i = 0; i < cnt; i++){
            for(int j = 1; j <= 5; j++){
                checkerRowThreads[i] = new Thread(new BingoRowChecker(cards.get(i), j));
                checkerRowThreads[i].start();

                checkerColThreads[i] = new Thread(new BingoColumnChecker(cards.get(i), j));
                checkerColThreads[i].start();

            }
        }



        int temp;
        while(!bingo_indetifier){

            do{
                temp = generateRandomNumber(1,75);
            } while (result[temp]);

            result[temp] = true;
            System.out.print(temp + " ");

            synchronized (result){
                result.notifyAll();
            }


            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }

    private int generateRandomNumber(int start, int end){
        return  (int)(Math.random() * (end - start + 1)) + start;
    }
}
