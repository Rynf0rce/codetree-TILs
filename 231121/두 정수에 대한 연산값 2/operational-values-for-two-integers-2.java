import java.util.*;

class conInt{
    int value;

    conInt(int n){
        this.value = n;
    }
}

public class Main {
    public static void conFuc(conInt a, conInt b){
        if(a.value > b.value){
            a.value *= 2;
            b.value += 10;
        }
        else{
            a.value += 10;
            b.value *= 2;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        conInt a = new conInt(sc.nextInt()), b = new conInt(sc.nextInt());
        conFuc(a,b);
        System.out.printf("%d %d", a.value, b.value);
    }
}