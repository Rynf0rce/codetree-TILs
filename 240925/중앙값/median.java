import java.util.*;

public class Main {
    public static PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int t = sc.nextInt();

        for(int i = 0 ; i < t ; i++){
            int m = sc.nextInt();

            int median = 0;
            int leftSize = 0;
            int rightSize = 0;

            leftQueue.clear();
            rightQueue.clear();

            for(int j = 1 ; j <= m ; j++){
                int num = sc.nextInt();

                if(j == 1){
                    median = num;
                    System.out.print(median + " ");
                    continue;
                }

                if(num > median){
                    rightQueue.add(num);
                }
                else{
                    leftQueue.add(num);
                }

                if(j % 2 == 1){
                    int leftDiff = leftQueue.size() - leftSize;
                    int rightDiff = rightQueue.size() - rightSize;

                    if(leftDiff > rightDiff){
                        rightQueue.add(median);
                        median = leftQueue.poll();
                    }
                    else if(rightDiff > leftDiff){
                        leftQueue.add(median);
                        median = rightQueue.poll();
                    }

                    leftSize = leftQueue.size();
                    rightSize = rightQueue.size();
                    System.out.print(median + " ");
                }
            }
            System.out.println();
        }
    }
}