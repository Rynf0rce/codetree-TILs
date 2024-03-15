import java.util.*;
public class Main {
    public static ArrayList<Integer> numList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numList.add(1);
        numList.add(sc.nextInt());
        while(true){
            int num = numList.get(numList.size() - 1) + numList.get(numList.size() - 2);
            numList.add(num);
            if(num > 999){
                break;
            }
        }

        for(int num : numList){
            System.out.print(num + " ");
        }
        
    }
}