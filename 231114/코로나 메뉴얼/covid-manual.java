import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char coldOne = sc.next().charAt(0);
        int tempertureOne = sc.nextInt();
        char coldTwo = sc.next().charAt(0);
        int tempertureTwo = sc.nextInt();
        char coldThree = sc.next().charAt(0);
        int tempertureThree = sc.nextInt();
        int emergencyCounter = 0;
        char output = 'N';

        if(coldOne == 'Y' && tempertureOne >= 37){
            emergencyCounter += 1;
        }

        if(coldTwo == 'Y' && tempertureTwo >= 37){
            emergencyCounter += 1;
        }

        if(coldThree == 'Y' && tempertureThree >= 37){
            emergencyCounter += 1;
        }

        if(emergencyCounter >= 2){
            output = 'E';
        }
        else{
            output = 'N';
        }
        System.out.print(output);
    }
}