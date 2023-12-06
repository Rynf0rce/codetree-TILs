import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // 제일 작은 값은 A와 B가 자명하다.
        // C는 왜 arr[2]가 되지 못하는가?
        // 만약 a = 1 b = 2 c = 4 일경우 생각해보면, a+b = 3 인 값이 생기게 되고
        // 이후 배열을 정렬했을때 나오는 값의 3번째가 3인걸 생각해보면 당연히 아닌걸 알 수 있다.
        // 그래서 a + b + c는 3개의 합이므로 모든 정수 중에 가장 크기 때문에
        // 크기가 큰 값(a+b+c)와 제일 크기가 작은 a와 b의 차로 c를 구할 수 있다.
        int a = arr[0];
        int b = arr[1];
        int c = arr[6] - a - b;
        System.out.print(a + " " + b + " " + c);
    }
}

/* public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        int[] tempArr = new int[7];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length - 2; i++){
            for(int j = i + 1 ; j < arr.length - 1 ; j++){
                Arrays.fill(tempArr, 0);
                int a = 0;
                int b = 0;
                int c = 0;
                for(int k = j + 1 ; k < arr.length ; k++){
                    tempArr[0] = a = arr[i];
                    tempArr[1] = b = arr[j];
                    tempArr[2] = c = arr[k];
                    tempArr[3] = arr[i] + arr[j];
                    tempArr[4] = arr[j] + arr[k];
                    tempArr[5] = arr[k] + arr[i]; 
                    tempArr[6] = arr[i] + arr[j] + arr[k];

                    Arrays.sort(tempArr);
                    boolean triger = true;
                    for(int h = 0 ; h < tempArr.length ; h++){
                        if(arr[h] != tempArr[h]){
                            triger = false;
                            break;
                        }
                    }
                    if(triger){
                        System.out.print(a + " " + b + " " + c);
                        System.exit(0);
                    }
                }    
            }
        }
    }
}
*/