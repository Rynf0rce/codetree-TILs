import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int i = 1;
        while(i < n){
            if(i % 2 == 1){
                bw.write(1 + " ");
            }
            else{
                bw.write(2 + " ");
            }
            i++;
        }
        if(i % 2 == 1){
            bw.write(3 + " ");
        }
        else{
            bw.write(2 + " ");
        }
        bw.flush();
        bw.close();
    }
}