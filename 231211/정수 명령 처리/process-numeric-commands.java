import java.util.*;

public class Main {
    public static Stack<Integer> vector = new Stack<>();
    public static void conFnc(String str, int data){
        switch(str){
            case "push" :
                vector.push(3);
                break;
            case "pop" :
                if(!vector.isEmpty()){
                    System.out.println(vector.pop());
                }
                break;
            case "size" :
                System.out.println(vector.size());
                break;
            case "empty" :
                System.out.println(vector.isEmpty() ? 1 : 0);
                break;
            case "top" :
                System.out.println(vector.peek());
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            int j = 0 ;
            if(str.equals("push")){
                j = sc.nextInt();
            }
            conFnc(str, j);
        }
    }
}