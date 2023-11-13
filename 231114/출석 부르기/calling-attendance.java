import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        String output = "Vacancy";
        if(inputNum == 1){
            output = "John";
        }
        else if(inputNum == 2){
            output = "Tom";
        }
        else if(inputNum == 3){
            output = "Paul";
        }
        System.out.print(output);
    }

}