import java.util.*;

public class Main {
    public static LinkedList<Integer> vector = new LinkedList<>();
    public static void conFnc(String str, int num){
        switch(str){
            case "push_front" :
                vector.addFirst(num);
                break;
            case "push_back" :
                vector.addLast(num);
                break;
            case "pop_front" :
                System.out.println(vector.pollFirst());
                break;
            case "pop_back" :
                System.out.println(vector.pollLast());
                break;
            case "size" :
                System.out.println(vector.size());
                break;
            case "empty" :
                System.out.println(vector.isEmpty() ? 1 : 0);
                break;
            case "front" :
                System.out.println(vector.peekFirst());
                break;
            case "back" :
                System.out.println(vector.peekLast());
                break;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            int num = 0;
            if(str.contains("push")){
                num = sc.nextInt();
            }
            conFnc(str, num);
        }
    }
}