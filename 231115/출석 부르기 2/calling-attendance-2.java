import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String output = " ";
        while(true){
            input = sc.nextInt();
            switch(input){
                case 1 :
                    output = "John";
                    break;
                case 2 : 
                    output = "Tom";
                    break;
                case 3 :
                    output = "Paul";
                    break;
                case 4 :
                    output = "Sam";
                    break;
                default :
                    output = "Vacancy";
                    break;
            }
            System.out.println(output);
            if(input > 4){
                break;
            }
        }
    }
}