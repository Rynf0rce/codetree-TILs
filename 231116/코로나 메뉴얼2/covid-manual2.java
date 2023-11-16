import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        char symptom = ' ';
        int temperture = 0;
        boolean emergency = false;
        for(int i = 0 ; i < 3 ; i++){
            symptom = sc.next().charAt(0);
            temperture = sc.nextInt();
            if(temperture >= 37){
                if(symptom == 'Y'){
                    arr[0]++;
                    if(arr[0] >1){
                        emergency = true;
                    }
                }
                else{
                    arr[1]++;
                }
            }
            else{
                if(symptom == 'Y'){
                    arr[2]++;
                }
                else{
                    arr[3]++;
                }
            }
        }
        System.out.printf("%d %d %d %d %c",arr[0], arr[1], arr[2], arr[3], emergency ? 'E' : ' ' );
        
    }
}