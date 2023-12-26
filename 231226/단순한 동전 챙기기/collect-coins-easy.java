import java.util.*;

class point implements Comparable<point>{
    int row;
    int col;
    int idx;

    public point(int row, int col, int idx){
        this.row = row;
        this.col = col;
        this.idx = idx;
    }

    @Override
    public int compareTo(point p){
        return this.idx - p.idx;
    }
}

public class Main {
    public static final int MAX_EDGE = 20;
    public static ArrayList<point> input = new ArrayList<>();
    public static ArrayList<Integer> vector = new ArrayList<>();
    public static int minVal = Integer.MAX_VALUE;

    public static int calDistance(point p1, point p2){
        return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
    }

    public static void getCoin(int idx, int coin, int distance){
        if(coin >= 3){
            minVal = Math.min(minVal, distance + calDistance(input.get(vector.get(vector.size() - 1)), input.get(input.size() - 1)));
            return;
        }

        for(int i = idx + 1 ; i < input.size() - 1 - (2 - coin) ; i++){
            vector.add(i);
            getCoin(i, coin + 1, distance + calDistance(input.get(idx), input.get(i)));
            vector.remove(vector.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0 ; i < 4; i++){
            String str = sc.next();
            for(int j = 0 ; j < str.length() ; j++){
                if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                    input.add(new point(i, j, str.charAt(j) - '0'));
                }
                else if(str.charAt(j) == 'S'){
                    input.add(new point(i, j, 0));
                }
                else if(str.charAt(j) == 'E'){
                    input.add(new point(i, j, 10));
                }
            }
        }

        Collections.sort(input);

        // for(int i = 0 ; i < input.size() ; i++){
        //     System.out.println(input.get(i).row + " " + input.get(i).col + " " + input.get(i).idx);
        // }

        getCoin(0, 0, 0);

        System.out.print(minVal == Integer.MAX_VALUE ? -1 : minVal);
    }
}