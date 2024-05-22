import java.util.*;
import java.io.*;

class Type implements Comparable<Type>{
    int num;
    public Type(int num){
        this.num = num;
    }
    @Override
    public int compareTo(Type t){
        int left = Integer.parseInt(Integer.toString(this.num) + Integer.toString(t.num));
        int right = Integer.parseInt(Integer.toString(t.num) + Integer.toString(this.num));
        return right - left;
    }
}

public class Main {
    public static PriorityQueue<Type> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            pq.add(new Type(Integer.parseInt(br.readLine())));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().num);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}