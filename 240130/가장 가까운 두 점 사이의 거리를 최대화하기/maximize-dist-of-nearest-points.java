import java.util.*;

class line implements Comparable<line>{
    int start;
    int end;

    public line(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(line l){
        if(this.start == l.start){
            return this.end - l.end;
        }
        else{
            return this.start - l.start;
        }
    }
}

public class Main {
    public static final int MAX_LINE = 100000;
    public static int MAX_X = 1000000000;
    public static line[] arr = new line[MAX_LINE];

    public static boolean isPossible(int length, int lineNum){
        int pos = arr[0].start;
        for(int i = 1 ; i < lineNum ; i++){
            pos += length;
            if(arr[i].start < pos && arr[i].end < pos){
                return false;
            }

            if(pos <= arr[i].start){
                pos = arr[i].start;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            arr[i] = new line(x1, x2);
        }

        Arrays.sort(arr, 0 , n);

        int start = 1;
        int end = MAX_X;
        int ans = 0;
        while(start <= end){
            int mid = (end + start) / 2;
            if(isPossible(mid, n)){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                end = mid - 1;
            }
        }

        System.out.print(ans);
    }
}