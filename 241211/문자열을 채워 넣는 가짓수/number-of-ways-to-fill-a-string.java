import java.util.*;
import java.io.*;

class AhoCorasick {
    static final int ALPHABET_SIZE = 26;
    static final int MOD = 1000000007;

    class Node {
        int[] next = new int[ALPHABET_SIZE];
        int fail; 
        ArrayList<Integer> out = new ArrayList<>(); 
        Node() {
            Arrays.fill(next, -1);
        }
    }

    ArrayList<Node> trie;
    public AhoCorasick() {
        trie = new ArrayList<>();
        trie.add(new Node());
    }

    private int charToIndex(char c) {
        return c - 'a';
    }

    public void insert(String s, int idx) {
        int cur = 0;
        for (char c : s.toCharArray()) {
            int cidx = charToIndex(c);
            if (trie.get(cur).next[cidx] == -1) {
                trie.get(cur).next[cidx] = trie.size();
                trie.add(new Node());
            }
            cur = trie.get(cur).next[cidx];
        }
        // 패턴 종료 시 out에 패턴 인덱스 기록 (패턴 길이 대신 바로 기록 가능)
        // 여기서는 패턴 인덱스 대신 패턴 길이를 저장하자.
        trie.get(cur).out.add(s.length());
    }

    public void buildFail() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            int nxt = trie.get(0).next[i];
            if (nxt != -1) {
                trie.get(nxt).fail = 0;
                q.add(nxt);
            } else {
                trie.get(0).next[i] = 0;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int f = trie.get(cur).fail;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                int nxt = trie.get(cur).next[i];
                if (nxt != -1) {
                    trie.get(nxt).fail = trie.get(f).next[i];
                    trie.get(nxt).out.addAll(trie.get(trie.get(nxt).fail).out);
                    q.add(nxt);
                } else {
                    trie.get(cur).next[i] = trie.get(f).next[i];
                }
            }
        }
    }

    public long countWays(String T) {
        long[] dp = new long[T.length() + 1];
        dp[0] = 1;

        int state = 0;
        for (int i = 0; i < T.length(); i++) {
            int c = T.charAt(i) - 'a';
            state = trie.get(state).next[c];
            // 해당 상태(또는 suffix link를 통해)에서 나오는 패턴들의 길이로 dp 갱신
            for (int length : trie.get(state).out) {
                int startIndex = i + 1 - length; // 패턴 시작 지점
                dp[i + 1] = (dp[i + 1] + dp[startIndex]) % MOD;
            }
        }

        return dp[T.length()];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String T = st.nextToken();
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        AhoCorasick aho = new AhoCorasick();
        for (int i = 0; i < m; i++) {
            String p = st.nextToken();
            aho.insert(p, i);
        }

        aho.buildFail();
        System.out.println(aho.countWays(T));
    }
}
