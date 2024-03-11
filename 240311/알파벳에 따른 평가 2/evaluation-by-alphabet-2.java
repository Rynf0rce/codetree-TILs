import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char inChar = sc.next().charAt(0);
        String str = " ";
        switch(inChar){
            case 'S' :
                str = "Superior";
                break;
            case 'F' :
                str = "Fantastic";
                break;
            case 'G' :
                str = "Good";
                break;
            case 'U' :
                str = "Usually";
                break;
            case 'E' :
                str = "Effort";
                break;
            default :
                str = "Failure";
                break;
        }
        System.out.print(str);
    }
}