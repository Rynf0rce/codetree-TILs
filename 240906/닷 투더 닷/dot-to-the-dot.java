import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node {
    int index, l, c;
    
    public Node(int index, int l, int c) {
        this.index = index;
        this.l = l;
        this.c = c;
    }
};

class Element implements Comparable<Element> {
    int dist, index;
    
    public Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.dist - e.dist; 
    }
};

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 500;
    public static int n, m, x;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static ArrayList<Integer> cList = new ArrayList<>();
    public static int[] dist = new int[MAX_N + 1];
    public static double ans = 1e9;

    public static void dijkstra(int k, int cLimit) {
        for(int i = 1; i <= n; i++)
            dist[i] = (int)1e9;
    
        dist[k] = 0;
    
        pq.add(new Element(0, k));
    
        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();
    
            if(minDist != dist[minIndex])
                continue;
    

            for(int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetL = graph[minIndex].get(j).l;
                int targetC = graph[minIndex].get(j).c;
                

                if(targetC < cLimit)
                    continue;

                int newDist = dist[minIndex] + targetL;
                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();

        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int l = sc.nextInt();
            int c = sc.nextInt();
            graph[x].add(new Node(y, l, c));
            graph[y].add(new Node(x, l, c));

            cList.add(c);
        }

        for(int i = 0; i < cList.size(); i++) {
            int cLimit = cList.get(i);
            dijkstra(1, cLimit);
            ans = Math.min(ans, dist[n] + (double) x / cLimit);
        }

        System.out.print((int)ans);
    }
}