import java.util.*;

public class Main {
    public static final int MAX_PEOPLE = 11;
    public static final int MAX_LINE = 15;
    public static int[] peopleArr = new int[MAX_PEOPLE];
    public static int[] answer = new int[MAX_PEOPLE];
    public static int[][] area = new int[MAX_LINE][MAX_PEOPLE];
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int n;
    public static int m;
    public static int minVal = Integer.MAX_VALUE;

    public static void printArea(){
        for(int i = 0 ; i < MAX_LINE ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
    }

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

    public static void areaReset(){
        for(int i = 0; i < MAX_LINE ; i++){
            for(int j = 0 ; j < n ; j++){
                area[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && col >= 0 && row < MAX_LINE && col < n);
    }

    public static int go(int row, int col){
        //System.out.println(row + " " + col);
        //printArea();
        //System.out.println();
        if(area[row][col] > 0){
            if(inRange(row, col - 1) && area[row][col - 1] == area[row][col]){
                return col - 1;
            }
            else if(inRange(row, col + 1)){
                return col + 1;
            }
        }
        return col;
    }
 
    public static void play(){
        for(int i = 0 ; i < n ; i++){
            int peopleIdx = peopleArr[i];
            for(int j = 0 ; j < MAX_LINE ; j++){
                peopleIdx = go(j, peopleIdx);
            }
            peopleArr[i] = peopleIdx;
        }
    }

    public static boolean isPossible(){
        areaReset();
        int cnt = 1;
        for(int i = 0 ; i < vector.size() ; i++){
            int num = vector.get(i);
            int row = num / n;
            int col = num % n;
            if((inRange(row, col) && area[row][col] == 0) && ( (inRange(row, col + 1) && area[row][col] == 0) )){
                area[row][col] = cnt;
                area[row][col+1] = cnt++;
            }
            else{
                return false;
            }
        }
        return true;
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

    public static void conFnc(int num, int cross){
        if(num > cross * n || cross > m){
            return;
        }

        if(vector.size() >= cross){
            if(isPossible() && matchAnswer()){
                minVal = Math.min(minVal, cross);
                System.out.println(minVal);
                System.exit(0);
            }
            return;
        }

        vector.add(num);
        conFnc(num + 2, cross);
        vector.remove(vector.size() - 1);

        conFnc(num + 1, cross);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt = 1;
        peopleArrReset();
        for(int i = 0 ; i < m ; i++){
            int c = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            area[r][c] = cnt;
            area[r][c+1] = cnt++;
        }

        play();
        for(int i = 0 ; i < n ; i++){
            answer[i] = peopleArr[i];
        }

        for(int i = 0 ; i <= m ; i++){
            conFnc(0, i);
        }

        // conFnc(0, 1);
        // System.out.println(minVal);       
    }
}