import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0 ; i < 3 ; i++){
            sum += String.valueOf(br.readLine()).length();
        }
        System.out.print(sum);
    }
}