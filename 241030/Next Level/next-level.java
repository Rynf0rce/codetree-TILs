import java.util.*;

class codetree{
    String ID;
    int lev;
    
    public codetree(){
        this.ID = "codetree";
        this.lev = 10;
    }

    public codetree(String ID, int lev){
        this.ID = ID;
        this.lev = lev;
    }

    public void print(){
        System.out.println("user " + ID + " lv " + lev);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int lev = sc.nextInt();

        codetree a = new codetree();
        codetree b = new codetree(str, lev);

        a.print();
        b.print();
    }
}