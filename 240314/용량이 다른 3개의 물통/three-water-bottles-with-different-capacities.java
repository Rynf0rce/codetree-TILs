import java.util.*;
import java.io.*;
public class Main {
    public static long[] storage = new long[3];
    public static long[] water = new long[3];

    public static void giveWater(int i, int j){
        if(storage[j] >= water[i] + water[j]){
            water[j] += water[i];
            water[i] = 0;
        }
        else{
            long carry = storage[j] - water[j];
            water[j] = storage[j];
            water[i] -= carry;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            storage[i] = Long.parseLong(st.nextToken());
            water[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0 ; i < 100 ; i++){
            if(i % 3 == 0){
                giveWater(0, 1);
            }
            else if(i % 3 == 1){
                giveWater(1, 2);
            }
            else{
                giveWater(2, 0);
            }
        }

        for(int i = 0 ; i < 3 ; i++){
            System.out.println(water[i]);
        }
    }
}