import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

        while (true) {
            String line = br.readLine().trim();
            if (line.equals("end")) break;

            String[] words = line.split("\\s+"); // 단어 분리
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            // 현재까지의 단어와 빈도수 출력
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
