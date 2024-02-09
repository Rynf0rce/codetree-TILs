import java.util.*;
import java.io.*;

class node implements Comparable<node>{
    int idx;
    long weight;

    public node(int idx, long weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(node n){
        if(this.weight > n.weight){
            return 1;
        }
        else if(this.weight == n.weight){
            return 0;
        }
        else{
            return -1;
        }
    }
}

class load implements Comparable<load>{
    int start;
    int end;
    long weight;

    public load(int start, int end, long weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(load l){
        if(this.weight > l.weight){
            return 1;
        }
        else if(this.weight == l.weight){
            return 0;
        }
        else{
            return -1;
        }
    }
}


public class Main {
    public static final int MAX_NODE = 250;
    public static final long INVALID = (long)1e12;
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static PriorityQueue<node> pq = new PriorityQueue<>();
    public static TreeSet<load> loadSet = new TreeSet<>();
    public static long[] dist = new long[MAX_NODE + 1];
    public static int[] path = new int[MAX_NODE + 1];
    public static int N = -1;

    public static void dijkstra(){
        for(int i = 2 ; i <= MAX_NODE ; i++){
            dist[i] = INVALID;
            path[i] = 1;
        }

        pq.add(new node(1, dist[1]));
        while(!pq.isEmpty()){
            node curNode = pq.poll();
            if(curNode.weight != dist[curNode.idx]){
                continue;
            }

            for(int i = 0 ; i < nodeList[curNode.idx].size() ; i++){
                node postNode = nodeList[curNode.idx].get(i);
                if(dist[postNode.idx] > postNode.weight + curNode.weight){
                    dist[postNode.idx] = postNode.weight + curNode.weight;
                    pq.add(new node(postNode.idx, dist[postNode.idx]));
                    path[postNode.idx] = curNode.idx;
                }
            }
        }
    }

    public static void upScale(){
        int curIdx = N;
        loadSet.clear();
        while(curIdx != 1){
            loadSet.add(new load(path[curIdx], curIdx, dist[curIdx] - dist[path[curIdx]]));
            curIdx = path[curIdx];
        }

        for(int i = 0 ; i < nodeList[loadSet.last().start].size() ; i++){
            node savedNode = nodeList[loadSet.last().start].get(i);
            if(savedNode.idx == loadSet.last().end){
                nodeList[loadSet.last().start].remove(savedNode);
                nodeList[loadSet.last().start].add(new node(savedNode.idx, savedNode.weight * 2));
            }
        }

        for(int i = 0 ; i < nodeList[loadSet.last().end].size() ; i++){
            node savedNode = nodeList[loadSet.last().end].get(i);
            if(savedNode.idx == loadSet.last().start){
                nodeList[loadSet.last().end].remove(savedNode);
                nodeList[loadSet.last().end].add(new node(savedNode.idx, savedNode.weight * 2));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= N ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            nodeList[start].add(new node(end, weight));
            nodeList[end].add(new node(start, weight));
        }

        dijkstra();

        long ans = dist[N];

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(dist[i] + " ");
        // }

        // System.out.println();

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(path[i] + " ");
        // }

        // System.out.println();

        upScale();

        // for(load l : loadSet){
        //     System.out.println(l.start + " " + l.end + " " + l.weight);
        // }

        dijkstra();

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(dist[i] + " ");
        // }

        // System.out.println();

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(path[i] + " ");
        // }

        // System.out.println();

        System.out.print(dist[N] - ans);
    }
}