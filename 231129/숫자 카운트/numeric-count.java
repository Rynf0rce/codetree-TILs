import java.util.*;

class info{
    int num;
    int cntA;
    int cntB;

    info(){};
    
    info(int num, int cntA, int cntB){
        this.num = num;
        this.cntA = cntA;
        this.cntB = cntB;
    }
}

public class Main {
    public static int chackA(int target, int input){
        if(target == 0 || input == 0){
            return 0;
        }
        else{
            if(target % 10 == input % 10){
                return chackA(target/10, input/10) + 1;
            }
            else{
                return chackA(target/10, input/10);
            }
        }
    }

    public static int chackB(int target, int input){
        int cnt = 0;
        if(target/100 == (input%100)/10 || target/100 == input%10){
            cnt++;
        }
        if((target%100)/10 == input/100 || (target%100)/10 == input%10){
            cnt++;
        }
        if(target%10 == input / 100 || target%10 == (input%100)/10){
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        info[] arr = new info[N];
        for(int i = 0; i < arr.length ; i++){
            int num = sc.nextInt();
            int cntA = sc.nextInt();
            int cntB = sc.nextInt();
            arr[i] = new info(num, cntA, cntB);
        }

        int output = 0;

        for(int i = 1; i < 10 ; i++){
            for(int j = 1 ; j < 10 ; j++){
                if(i == j){
                    continue;
                }
                for(int k = 1 ; k < 10 ; k++){
                    if(i == k || j == k){
                        continue;
                    }
                    int currentVal = i * 100 + j * 10 + k;
                    int cnt = 0;
                    for(int h = 0 ; h < arr.length ; h++){
                        if(arr[h].cntA == chackA(currentVal, arr[h].num) && arr[h].cntB == chackB(currentVal, arr[h].num)){
                            cnt++;
                        }
                    }
                    if(cnt == arr.length){
                        output++;
                    }
                }
            }
        }
        System.out.println(output);
    }
}