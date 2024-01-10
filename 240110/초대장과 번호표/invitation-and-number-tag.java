import java.util.*;

public class Main {
    public static final int MAX_HUMAN = 100000;
    public static final int MAX_GROUP = 250000;

    public static HashSet<Integer>[] peopleSet = new HashSet[MAX_GROUP];
    public static HashSet<Integer> invited = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();

        invited.add(1);

        for(int i = 0 ; i < G ; i++){
            peopleSet[i] = new HashSet<Integer>();
            int fixedNum = sc.nextInt();
            for(int j = 0 ; j < fixedNum ; j++){
                int idx = sc.nextInt();
                peopleSet[i].add(idx);
            }
        }

        while(true){
            ArrayList<Integer> curInvited = new ArrayList<>(invited);
            for(int i = 0 ; i < curInvited.size() ; i++){
                for(int j = 0 ; j < G ; j++){
                    peopleSet[j].remove(curInvited.get(i));

                    if(peopleSet[j].size() == 1){
                        ArrayList<Integer> temp = new ArrayList<>(peopleSet[j]);
                        invited.add(temp.get(0));
                        peopleSet[j].remove(temp.get(0));
                    }
                }
            }
            
            if(curInvited.size() == invited.size()){
                break;
            }
        }

        System.out.println(invited.size());
        
    }
}