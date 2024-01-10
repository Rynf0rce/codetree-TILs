import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();
        int n = sc.nextInt();
        int value = 0;
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            switch(str){
                case "add" :
                    value = sc.nextInt();
                    s.add(value);
                    break;
                case "remove" :
                    value = sc.nextInt();
                    s.remove(value);
                    break;
                case "find" :
                    value = sc.nextInt();
                    if(s.contains(value)){
                        System.out.println(true);
                    }
                    else{
                        System.out.println(false);
                    }
                    break;
                case "lower_bound" :
                    value = sc.nextInt();
                    System.out.println(s.ceiling(value) == null ? "None" : s.ceiling(value));
                    break;
                case "upper_bound" :
                    value = sc.nextInt();
                    System.out.println(s.higher(value) == null ? "None" : s.higher(value));
                    break;
                case "largest" :
                    if(s.size() <= 0){
                        System.out.println("None");
                        break;
                    }
                    System.out.println(s.last());
                    break;
                case "smallest" :
                    if(s.size() <= 0){
                        System.out.println("None");
                        break;
                    }
                    System.out.println(s.first());
                    break;
            }
        }
    }
}