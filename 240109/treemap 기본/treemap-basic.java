import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            int key = 0;
            int value = 0;
            switch(str){
                case "add" :
                    key = sc.nextInt();
                    value = sc.nextInt();
                    map.put(key, value);
                break;
                case "find" :
                    key = sc.nextInt();
                    if(map.containsKey(key)){
                        System.out.println(map.get(key));
                    }
                    else{
                        System.out.println("None");
                    }
                    break;
                case "remove" :
                    key = sc.nextInt();
                    map.remove(key);
                    break;
                case "print_list" :
                    Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
                    if(map.size() == 0){
                        System.out.println("None");
                        break;
                    }
                    while(iter.hasNext()){
                        Map.Entry<Integer, Integer> entry = iter.next();
                        System.out.print(entry.getValue() + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}