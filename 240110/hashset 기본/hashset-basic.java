import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> s = new HashSet<>();
        
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            int value = sc.nextInt();
            switch(str){
                case "add" :
                    s.add(value);
                    break;
                case "remove" :
                    s.remove(value);
                    break;
                case "find" :
                    if(s.contains(value)){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                    break;
            }
        }
    }
}