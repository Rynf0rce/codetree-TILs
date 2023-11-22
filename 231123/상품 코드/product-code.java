import java.util.*;

class productCode{
    String name;
    int num;
    
    productCode(){
        this.name = new String("codetree");
        this.num = 50;
    }

    productCode(String name, int num){
        this.name = name;
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int num = sc.nextInt();
        productCode product1 = new productCode();
        productCode product2 = new productCode(name, num);
        System.out.printf("product %d is %s\n", product1.num, product1.name);
        System.out.printf("product %d is %s\n", product2.num, product2.name);
    }
}