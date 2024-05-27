import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    int num, idx;
    public tuple(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
    @Override
    public int compareTo(tuple t){
        return this.num - t.num;
    }
}

public class Main {
    public static ArrayList<tuple> tupleList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tupleList.add(new tuple(y, x));
        }
        Collections.sort(tupleList);
        double ans = 0;
        int i = 0;
        int j = tupleList.size() - 1;
        while(i <= j){
            if(tupleList.get(i).idx == 0){
                i++;
            }
            if(tupleList.get(j).idx == 0){
                j--;
            }

            if(ans < tupleList.get(i).num + tupleList.get(j).num){
                ans = tupleList.get(i).num + tupleList.get(j).num;
            }
            
            tupleList.get(i).idx--;
            tupleList.get(j).idx--;
        }
        System.out.printf("%.0f", ans);
    }
}