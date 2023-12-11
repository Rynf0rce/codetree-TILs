import java.util.*;

public class Main {
    public static void conFnc(Deque vector, String str, int i){
        switch(str){
            case "push_front" :
                vector.addFirst(i);
                break;
            case "push_back" :
                vector.addLast(i);
                break;
            case "pop_front" :
                if(!vector.isEmpty()){
                    System.out.println(vector.pollFirst());
                }
                break;
            case "pop_back" :
                if(!vector.isEmpty()){
                    System.out.println(vector.pollLast());
                }
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
        Deque<Integer> vector = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            int num = 0;
            if(str.contains("push")){
                num = sc.nextInt();
            }
            conFnc(vector, str, num);
        }
    }
}