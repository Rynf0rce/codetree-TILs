import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int student = sc.nextInt(), sum = 0, cnt = 0;
        int[] grade = new int[4];
        for(int i = 0 ; i < student ; i++){
            sum = 0;
            for(int j = 0 ; j < grade.length ; j++){
                grade[j] = sc.nextInt();
                sum += grade[j];
            }
            if(sum / 4 >= 60){
                System.out.println("pass");
                cnt++;
            }
            else{
                System.out.println("fail");
            }
        }
        System.out.println(cnt);
    }
}