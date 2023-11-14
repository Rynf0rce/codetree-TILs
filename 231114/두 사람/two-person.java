import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstManOld = sc.nextInt();
        char firstManGender = sc.next().charAt(0);
        int secondManOld = sc.nextInt();
        char secondManGender = sc.next().charAt(0);
        int output = 0;

        if((firstManOld >= 19 && firstManGender == 'M') || (secondManOld >= 19 && firstManGender == 'M')){
            output = 1;
        }
        else{
            output = 0;
        }
        System.out.print(output);
    }
}