import java.util.*;
import java.io.*;

class vertax implements Comparable<vertax>{
    int idx, weight;
    
    public vertax(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(vertax v){
        return this.weight - v.weight;
    }
}

public class Main {
    public static final int MAX_VERTEX = 1000;
    public static final int MAX_INT = (int)1e9;
    public static int[] dist = new int[MAX_VERTEX + 1];
    public static ArrayList<vertax>[] vertaxList = new ArrayList[MAX_VERTEX + 1];
    public static PriorityQueue<vertax> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            vertaxList[i] = new ArrayList<vertax>();
            dist[i] = MAX_INT;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertaxList[start].add(new vertax(end, weight));
            vertaxList[end].add(new vertax(start, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dist[A] = 0;
        pq.add(new vertax(A, dist[A]));
        while(!pq.isEmpty()){
            vertax curVertax = pq.poll();
            if(curVertax.weight != dist[curVertax.idx]){
                continue;
            }

            for(int i = 0 ; i < vertaxList[curVertax.idx].size() ; i++){
                vertax postVertax = vertaxList[curVertax.idx].get(i);
                if(dist[postVertax.idx] > curVertax.weight + postVertax.weight){
                    dist[postVertax.idx] = curVertax.weight + postVertax.weight;
                    pq.add(new vertax(postVertax.idx, dist[postVertax.idx]));
                }
            }
        }
        System.out.print(dist[B]);
    }
}