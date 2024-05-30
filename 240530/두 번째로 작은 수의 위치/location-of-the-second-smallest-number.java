import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100;
    
    public static int n;
    
    public static int[] a = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        
        // 새로운 배열을 만들어 정렬하고
        // 2번째로 작은 숫자를 찾아냅니다.
        int[] myarr = new int[MAX_N + 1];
        for(int i = 1; i <= n; i++)
            myarr[i] = a[i];
        Arrays.sort(myarr, 1, n + 1);
        
        // isexist : 2번째로 작은 숫자가 존재하면 true
        boolean isexist = false;
        int low2 = 0;
        for(int i = 1; i <= n; i++) {
            // 가장 처음으로 myarr[1]과 다른 숫자는
            // 2번째로 작은 숫자라고 할 수 있습니다.
            if(myarr[i] != myarr[1]) {
                low2 = myarr[i];
                isexist = true;
                break;
            }
        }

        // 2번째로 작은 숫자가 존재하지 않을 때
        if(isexist == false) {
            System.out.print(-1);
            System.exit(0);
        }

        int ansidx = -1;
        for(int i = 1; i <= n; i++) {
            if(a[i] == low2) {
                // 2번째로 작은 숫자가 여러 개 있을 때
                if(ansidx != -1) {
                    System.out.print(-1);
                    System.exit(0);
                }

                ansidx = i;
            }
        }

        System.out.print(ansidx);
    }
}