import java.util.*;

class bridge implements Comparable<bridge>{
    int a;
    int b;
    public bridge(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(bridge input){
        return this.b - input.b;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 11;
    public static final int MAX_LINE = 15;
    public static int[] peopleArr = new int[MAX_PEOPLE];
    public static int[] answer = new int[MAX_PEOPLE];
    public static ArrayList<bridge> bridgeList = new ArrayList<>();
    public static ArrayList<bridge> tempList = new ArrayList<>();
    public static int n;
    public static int m;


    public static void printPeople(){
        for(int i = 0 ; i < n ; i++){
            System.out.print(peopleArr[i] + " ");
        }
        System.out.println();
    }

    public static void peopleArrReset(){
        for(int i = 0; i < MAX_PEOPLE ; i++){
            peopleArr[i] = i;
        }
    }

    public static void swap(int idxA, int idxB){
        int temp = peopleArr[idxA];
        peopleArr[idxA] = peopleArr[idxB];
        peopleArr[idxB] = temp;
    }

    public static void play(){
        peopleArrReset();
        for(int i = 0 ; i < tempList.size() ; i++){
            bridge branch = tempList.get(i);
            swap(branch.a, branch.a + 1);
        }
    }

    public static boolean matchAnswer(){
        peopleArrReset();
        play();
        for(int i = 0 ; i < n ; i++){
            if(answer[i] != peopleArr[i]){
                return false;
            }
        }
        return true;        
    }

    public static void conFnc(int num, int range){
        // System.out.println(num);
        if(num > range){
            return;
        }

        if(tempList.size() >= range && matchAnswer()){
            System.out.print(num);
            System.exit(0);
        }

        for(int i = num ; i < bridgeList.size() ; i++){
            tempList.add(bridgeList.get(i));
            conFnc(num + 1, range);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt = 1;
        
        for(int i = 0 ; i < m ; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            bridgeList.add(new bridge(a, b));
        }
        
        Collections.sort(bridgeList);
        tempList = new ArrayList<>(bridgeList);

        play();
        for(int i = 0 ; i < n ; i++){
            answer[i] = peopleArr[i];
        }
        
        // printPeople();

        tempList.clear();

        for(int i = 0 ; i <= bridgeList.size() ; i++){
            conFnc(0, i);
            tempList.clear();
        }
    }
}