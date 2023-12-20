import java.util.*;

public class Main {
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int maxNum;
    public static int range;
    
    public static void print(){
        for(int i = 0 ; i < vector.size() ; i++){
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
    }
    public static void recursive(int curNum){
        if(curNum > range){
            print();
            return;
        }
        
        for(int i = 1 ; i <= maxNum ; i++){
            vector.add(i);
            recursive(curNum + 1);
            vector.remove(vector.size() - 1);
        } 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxNum = sc.nextInt();
        range = sc.nextInt();
        recursive(1);
    }
}