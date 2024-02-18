import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_IN = 5;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < MAX_IN ; i++){
            double num = Double.parseDouble(br.readLine());
            System.out.printf("%.3f%n", num);
        }
    }
}