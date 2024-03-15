import java.util.*;
public class Main {
    public static ArrayList<String> ansList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.next().charAt(0);
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            if(str.charAt(3) == c){
                ansList.add(str);
            }
        }

        System.out.println(ansList.size());
        for(String str : ansList){
            System.out.println(str);
        }
    }
}