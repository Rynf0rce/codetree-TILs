import java.util.*;

public class Main {
    public static Queue<Integer> vector = new LinkedList<>();
    public static void conFnc(String str, int num){
        switch(str){
            case "push" :
                vector.add(num);
                break;
            case "pop" :
                if(!vector.isEmpty()){
                    System.out.println(vector.poll());
                }
                break;
            case "size" :
                System.out.println(vector.size());
                break;
            case "empty" :
                System.out.println(vector.isEmpty() ? 1 : 0);
                break;
            case "front" :
                System.out.println(vector.peek());
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            int num = 0;
            if(str.equals("push")){
                num = sc.nextInt();
            }
            conFnc(str, num);
        }
    }
}