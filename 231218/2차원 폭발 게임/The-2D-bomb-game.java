import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[][] area = new int[MAX_RANGE][MAX_RANGE];

    public static void bomb(int N, int M){
        int[][] temp = new int[MAX_RANGE][MAX_RANGE];
        for(int i = 0 ; i < N ; i++){
            int value = area[N - 1][i];
            int cnt = 1;
            int idx = N - 1;
            for(int j = N - 2 ; j >= 0 ; j--){
                if(area[j][i] != 0){
                    if(value == area[j][i]){
                        cnt++;
                    }
                    else{
                        if(cnt < M){
                            for(int k = 0 ; k < cnt ; k++){
                                temp[idx--][i] = value;
                            }
                        }

                        value = area[j][i];
                        cnt = 1;
                    }
                } 
            }
            if(cnt < M){
                for(int k = 0 ; k < cnt ; k++){
                    temp[idx--][i] = value;
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                area[i][j] = temp[i][j];
            }
        }
    }

    public static void spin(int N){
        int[][] temp = new int[MAX_RANGE][MAX_RANGE];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                temp[j][i] = area[N - 1 - i][j];
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                area[i][j] = temp[i][j];
            }
        }
    }

    public static void conFnc(int N, int M){
        bomb(N, M);
        spin(N);
        bomb(N, M);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                area[i][j] = sc.nextInt();
            }
        }

        while(K-- > 0){
            conFnc(N, M);
        }

        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(area[i][j] != 0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}