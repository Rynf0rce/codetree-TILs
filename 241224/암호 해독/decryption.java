import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(decrypt(input));
    }

    public static String decrypt(String input) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '-': // 삭제
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case '<': // 왼쪽 이동
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case '>': // 오른쪽 이동
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                default: // 문자 삽입
                    leftStack.push(ch);
                    break;
            }
        }

        // 결과 문자열 생성
        StringBuilder result = new StringBuilder();
        for (char ch : leftStack) {
            result.append(ch);
        }
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        return result.toString();
    }
}
