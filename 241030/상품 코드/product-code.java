import java.util.*;

class product{
    String name;
    int num;
    public product(){
        this.name = "codetree";
        this.num = 50;
    }
    public product(String name, int num){
        this.name = name;
        this.num = num;
    }
    public void print(){
        System.out.println("product " + num + " is " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt();
        
        product a = new product();
        product b = new product(str, num);

        a.print();
        b.print();
    }
}