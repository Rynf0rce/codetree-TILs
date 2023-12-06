import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 1000;
    public static int[] arr = new int[INPUT_RANGE];
    public static int maxGroup(int evenCnt, int oddCnt, int order){
        // 홀수인 경우 홀수를 만들 수 있는 건 홀수 뿐이기 때문에 홀수의 총 수가 0 이면 값을 못 만듭니다.
        // 짝수인 경우 짝수 하나와 홀수 2개인 경우에 짝수를 만들 수 있읍니다.
        if( (order == 1 && oddCnt == 0) || (order == 2 && evenCnt == 0 && oddCnt < 2) ){
            return 0;
        }

        // 비록 홀수에 나누기 전에 이후에 짝수를 만들 수 있는지 봐야합니다.
        // 값이 2인경우 이후에 값을 빼고 나면 홀수의 수는 1개가 됨으로 짝수를 만들수 없습니다.
        // 따라서 이 경우를 제외하고는 짝수를 만들수 있습니다.
        if(order == 1 && (evenCnt > 0 || oddCnt != 2)){
            oddCnt--;
        }
        // 짝수를 만들기 위해 우선 짝수의 수를 먼저 빼줍니다.
        else if(order == 2 && evenCnt > 0) {
            evenCnt--;
        }
        // 이후 짝수의 수가 소진되면 홀수로 짝수를 채워줍니다.
        // 똑같이 홀수의 수가 2 이상이 되면 짝수를 만들기 위해 짝수를 빼주더라도
        // 이후 홀수를 만들거나 홀수가 없어 값을 만들 수 없을껍니다.
        else if(order == 2 && oddCnt > 1){
            oddCnt -= 2;
        }
        else{
            return 0;
        }
        
        // 짝수 -> 홀수, 홀수 -> 짝수.
        if(order == 1){
            order = 2;
        }
        else{
            order = 1;
        }
        // 이와 같은 과정을 한번 수행하면 한번 묶은것임으로 1을 더하고
        // 짝수와 홀수로 만들어주기 위해 사용한 변수의 차를 다시 재귀함수로 넣어 계산합니다.
        // 더 이상 나오는 값이 없을 때까지 반복하면 최대의 값을 구할 수 있을껍니다.
        return maxGroup(evenCnt, oddCnt, order) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), oddCnt = 0, evenCnt = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] % 2 == 0){
                evenCnt++;
            }
            else{
                oddCnt++;
            }
        }
        System.out.print(maxGroup(evenCnt, oddCnt, 2));
    }
}