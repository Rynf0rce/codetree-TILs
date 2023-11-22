import java.util.*;

class gameID{
    String ID;
    int lev;
    
    gameID(){
        this.ID = new String("codetree");
        this.lev = 10;
    }

    gameID(String ID, int lev){
        this.ID = ID;
        this.lev = lev;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ID = sc.next();
        int lev = sc.nextInt();
        gameID user1 = new gameID();
        gameID user2 = new gameID(ID, lev);
        System.out.println("user " + user1.ID + " lv " + user1.lev);
        System.out.println("user " + user2.ID + " lv " + user2.lev);
    }
}