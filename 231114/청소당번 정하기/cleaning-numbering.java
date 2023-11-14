import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt(), cleanClass = 0, cleancorridor = 0, cleanToilet = 0;
        for(int i = 1 ; i <= day ; i++){
            if(i % 12 == 0){
                cleanToilet++;
            }
            else if(i % 3 == 0){
                cleancorridor++;
            }
            else if(i % 2 == 0){
                cleanClass++;
            }
        }
        System.out.printf("%d %d %d", cleanClass, cleancorridor, cleanToilet);
    }
}