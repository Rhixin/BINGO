import java.util.ArrayList;

public class BingoCard {
    int[][] nums;
    int id;

    public BingoCard(int id){
        nums = new int[5][5];
        this.id = id;

        //TODO randomize
        //col1 1-15
        //col2 16-30
        //col3 31-45 mid is 0
        //col4 46-60
        //col5 61-75

        int temp = 0;

        ArrayList<Integer> buffer = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){

                do{
                    temp = generateRandomNumber(j*15 + 1, j*15 + 15);
                } while (buffer.contains(temp));

                buffer.add(temp);
                nums[i][j] = temp;
            }

        }

        nums[2][2] = 0;
    }

    private int generateRandomNumber(int start, int end){
        return  (int)(Math.random() * (end - start + 1)) + start;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                sb.append(nums[i][j]).append("\t");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
