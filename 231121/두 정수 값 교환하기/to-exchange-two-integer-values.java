import java.util.*;

class IntSwap{
    int value;

    public IntSwap(int value){
        this.value = value;
    }
}

public class Main {
    public static void swap(IntSwap n1, IntSwap n2){
        int temp = n1.value;
        n1.value = n2.value;
        n2.value = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntSwap a = new IntSwap(sc.nextInt()), b = new IntSwap(sc.nextInt());
        swap(a,b);
        System.out.printf("%d %d",a.value, b.value);

    }
}