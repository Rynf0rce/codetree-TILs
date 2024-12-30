import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // TreeSet을 사용하여 중복 제거 및 사전 순 정렬
        TreeSet<String> dictionary = new TreeSet<>();
        String[] words = input.split("\\s+");
        Collections.addAll(dictionary, words);

        // 결과 출력
        System.out.println(String.join(" ", dictionary));
    }
}
