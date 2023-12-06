import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrX = new int[4];
        int[] arrY = new int[4];
        for(int i = 0 ; i < arrX.length ; i++){
            arrX[i] = sc.nextInt();
            arrY[i] = sc.nextInt();
        }
        Arrays.sort(arrX);
        Arrays.sort(arrY);
        System.out.print((arrX[3] - arrX[0]) * (arrY[3] - arrY[0]));

    }
}