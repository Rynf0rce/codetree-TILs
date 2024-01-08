import java.util.*;

public class Main {
    public static Queue<Integer> intQueue = new LinkedList<>();

    public static void conFnc(String str, HashMap m){
        int key = intQueue.poll();

        switch(str){
            case "add" :
                int value = intQueue.poll();
                m.put(key, value);
                break;
            case "find" :
                if(m.containsKey(key)){
                    System.out.println(m.get(key));
                }
                else{
                    System.out.println("None");
                }
                break;
            case "remove" :
                m.remove(key);
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            int key = sc.nextInt();
            intQueue.add(key);
            if(str.equals("add")){
                int value = sc.nextInt();
                intQueue.add(value);
            }
            conFnc(str, m);
        }
    }
}