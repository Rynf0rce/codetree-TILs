import java.util.*;
import java.io.*;

class vertex implements Comparable<vertex>{
    int idx, weight;

    public vertex(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(vertex v){
        return this.weight - v.weight;
    }
}

class path{
    int start;
    int end;
    
    public path(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
	public int hashCode() {
		// int hash(Object ... values); // 가변인자
		return Objects.hash(start, end); //iv들을 다 적으면 된다
 	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof path)) return false;
		
		path p = (path)obj; //obj에는 name과 age가 없기 때문에 형변환 필요
		
		// 나 자신(this)의 이름과 나이를 p와 비교
		return this.start == p.start && this.end == p.end;
	}
    
}

public class Main {
    public static final int MAX_VERTEX = 100000;
    public static final int INVALUED = (int)1e10;
    public static ArrayList<vertex>[] vertexList = new ArrayList[MAX_VERTEX + 1];
    public static PriorityQueue<vertex> pq = new PriorityQueue<>();
    public static HashSet<path> hs = new HashSet<>();
    public static HashMap<path, Integer> hm = new HashMap<>();
    public static int[] dist = new int[MAX_VERTEX + 1];
    public static int[] pathArr = new int[MAX_VERTEX + 1];
    public static int N, M;
    public static int[] redVertex = new int[2];

    public static void initialize(){
        for(int i = 1 ; i <= N ; i++){
            dist[i] = INVALUED;
            pathArr[i] = INVALUED;
        }
    }

    public static int shortestPath(int startIdx){
        hs.clear();
        hm.clear();
        if(dist[redVertex[0]] == INVALUED || dist[redVertex[1]] == INVALUED){
            return -1;
        }
        
        for(int i = 0 ; i < redVertex.length ; i++){
            int curIdx = redVertex[i];
            while(curIdx != startIdx){
                path goPath = new path(curIdx, pathArr[curIdx]);
                path backPath = new path(pathArr[curIdx], curIdx);
                hs.add(goPath);
                hs.add(backPath);
                hm.put(goPath, dist[curIdx] - dist[pathArr[curIdx]]);
                hm.put(backPath, dist[curIdx] - dist[pathArr[curIdx]]);
                curIdx = pathArr[curIdx];
            }
        }
        
        int ans = 0;
        for(path curPath : hs){
            // System.out.println(curPath.start + " " + curPath.end + " " + hm.get(curPath));
            ans += hm.get(curPath);
        }
        return ans;
    }

    public static void dijkstra(int startIdx){
        initialize();
        dist[startIdx] = 0;
        pathArr[startIdx] = startIdx;
        pq.add(new vertex(startIdx, dist[startIdx]));
        while(!pq.isEmpty()){
            vertex curVertex = pq.poll();
            if(dist[curVertex.idx] != curVertex.weight){
                continue;
            }

            for(int i = 0 ; i < vertexList[curVertex.idx].size() ; i++){
                vertex postVertex = vertexList[curVertex.idx].get(i);

                if(dist[postVertex.idx] > postVertex.weight + curVertex.weight){
                    dist[postVertex.idx] = postVertex.weight + curVertex.weight;
                    pq.add(new vertex(postVertex.idx, dist[postVertex.idx]));
                    pathArr[postVertex.idx] = curVertex.idx;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        redVertex[0] = Integer.parseInt(st.nextToken());
        redVertex[1] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            vertexList[i] = new ArrayList<vertex>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertexList[start].add(new vertex(end, weight));
            vertexList[end].add(new vertex(start, weight));
        }

        int ans = 0 ;

        for(int i = 1 ; i <= N ; i++){
            if(i == redVertex[1] || i == redVertex[1]){
                continue;
            }
            dijkstra(i);
            ans = Math.max(shortestPath(i), ans);
        }

        System.out.print(ans);

        //dijkstra(1);

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(dist[i] + " ");
        // }
        // System.out.println();
        // for(int i = 1 ; i <= N ; i++){
        //     System.out.print(pathArr[i] + " ");
        // }

        // System.out.println();

        //System.out.println(shortestPath(1));
    }
}