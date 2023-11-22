import java.util.*;

class agent{
    char name;
    int score;
    
    public agent(){
        this.name = ' ';
        this.score = 0;
    }
    
    public agent(char name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        agent[] agentList = new agent[5];
        int idx = 0, min = Integer.MAX_VALUE;
        char name = ' ';
        int score = 0;
        for(int i = 0 ; i < agentList.length ; i++){
            name = sc.next().charAt(0);
            score = sc.nextInt();
            agentList[i] = new agent(name, score);
            if(min > score){
                min = score;
                idx = i;
            }
        }

        System.out.printf("%c %d", agentList[idx].name, agentList[idx].score);

        
    }
}