import java.util.*;

public class Main {
    public static boolean fucLeap(int year){
        if(year % 400 == 0){
            return true;
        }
        else if(year % 100 == 0){
            return false;
        }
        else if(year % 4 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean conFuc(int Y, int M, int D){
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(fucLeap(Y)){
            days[1] = 29;
        }
        if(M >= 1 && M <= 12){
            if(days[M-1] >= D){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt(), mouth = sc.nextInt(), day = sc.nextInt();
        String season = "";
        if(conFuc(year, mouth, day)){
            if(mouth >= 12 || mouth <= 2){
                season = "Winter";
            }
            else if(mouth <= 5){
                season = "Spring";
            }
            else if(mouth <= 8){
                season = "Summer";
            }
            else{
                season = "Fall";
            }
        }
        else{
            System.out.print("-1");
        }
        System.out.print(season);
    }

}