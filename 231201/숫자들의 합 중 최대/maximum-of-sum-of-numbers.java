import java.util.*;

public class Main {
    public static int eachNumPlus(int x){
        if(x < 10){
            return x;
        }
        else{
            return eachNumPlus(x/10) + (x%10);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), Y = sc.nextInt(), maxVal = Integer.MIN_VALUE;
        for(int i = X ; i <= Y ; i ++){
            maxVal = Math.max(maxVal, eachNumPlus(i));
        }
        System.out.print(maxVal);
    }
}