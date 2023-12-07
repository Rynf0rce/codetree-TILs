import java.util.*;

public class Main {
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static void order(String str, int num){
        switch(str){
            case "push_back" :
                vector.add(num);
                break;
            case "pop_back" :
                vector.remove(vector.size() - 1);
                break;
            case "size" :
                System.out.println(vector.size());
                break;
            case "get" :
                System.out.println(vector.get(num-1));
                break;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            String inputText = sc.next();
            int num = 0;
            if(inputText.equals("push_back") || inputText.equals("get")){
                num = sc.nextInt();
            }
            order(inputText, num);
        }
    }
}