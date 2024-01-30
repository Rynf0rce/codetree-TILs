import java.util.*;
import java.io.*;

class line implements Comparable<line>{
    long start;
    long end;
    
    public line(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(line l){
        if(this.start > l.start){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static ArrayList<line> lineList = new ArrayList<>();
    public static long MAX_LONG = 1000000000000000000L;

    public static boolean isPossible(long length, int lineNum, int target){
        int cnt = 1;
        long pos = lineList.get(0).start;
        int idx = 0;
        while(cnt < target && idx < lineNum){
            // System.out.println("pos : " + pos + " cnt : " + cnt );
            if(lineList.get(idx).start <= pos + length && pos + length <= lineList.get(idx).end){
                // System.out.println("A");
                cnt++;
                pos += length;
            }
            else if(pos + length <= lineList.get(idx).start){
                // System.out.println("B");
                cnt++;
                pos = lineList.get(idx).start;
            }
            else{
                // System.out.println("C");
                idx++;
            }
        }
        return cnt >= target;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lineList.add(new line(a, b));
        }

        Collections.sort(lineList);

        long start = 0;
        long end = MAX_LONG;
        long ans = 0;
        while(start <= end){
            long mid = (end + start) / 2;
            // System.out.println(mid);
            if(isPossible(mid, M, N)){
                // System.out.println("yes");
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                // System.out.println("no");
                end = mid - 1;
            }
        }

        bw.write(end + "");
        
        br.close();
        bw.close();
    }
}