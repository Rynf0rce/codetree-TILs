import java.util.*;

class CalInt{
    int value;

    public CalInt(int n){
        this.value = n;
    }
}

public class Main {
    public static void conFuc(CalInt a, CalInt b){
        if(a.value > b.value){
            a.value += 25;
            b.value *= 2;
        }
        else{
            a.value *= 2;
            b.value += 25;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalInt a = new CalInt(sc.nextInt()), b = new CalInt(sc.nextInt());
        conFuc(a, b);
        System.out.printf("%d %d", a.value, b.value);
    }
}