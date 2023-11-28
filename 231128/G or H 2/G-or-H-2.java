import java.util.*;

public class Main {
    public static final int TOTAL_LOCATION = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = new char[TOTAL_LOCATION];
        Arrays.fill(arr, 'N');
        int n = sc.nextInt(), width = 1, cntG = 0, cntH = 0, sameGH = 0, maxVal = 0;
        for(int i = 0 ; i < n ; i++){
            int location = sc.nextInt();
            arr[location - 1] = sc.next().charAt(0);
        }

        while(width < TOTAL_LOCATION){
            width++;
            for(int i = 0 ; i < arr.length - width ; i++){
                cntG = 0;
                cntH = 0;
                for(int j = i ; j <= i + width ; j++){
                    if(arr[j] == 'G'){
                        cntG++;
                    }
                    else if(arr[j] == 'H'){
                        cntH++;
                    }
                }
                if(cntG == cntH && sameGH < cntG){
                    sameGH = cntG;
                    maxVal = Math.max(maxVal, width);
                }
            }
        }
        System.out.print(maxVal);    
    }
}