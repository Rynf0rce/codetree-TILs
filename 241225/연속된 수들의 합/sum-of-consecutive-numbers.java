import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(countConsecutiveSums(n));
    }

    public static int countConsecutiveSums(int n) {
        int count = 0;

        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            int remainder = n - k * (k - 1) / 2;
            if (remainder % k == 0) {
                count++;
            }
        }

        return count;
    }
}
