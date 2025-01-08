import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> mount = new ArrayList<>();
    static List<Integer> indexArr = new ArrayList<>();
    
    // 이분 탐색 함수:
    // 새 산 높이 h가 삽입될 '더미'의 인덱스를 찾는다.
    // (mount[i]의 마지막 원소 >= h 인 i 중 가장 작은 i)
    // 없으면 mount.size() (즉, 새로운 더미를 만든다)
    static int search(int h) {
        if (mount.isEmpty()) {
            return 0;
        }
        int s = 0;
        int e = mount.size() - 1;
        int idx = mount.size(); // 초기값: 없으면 맨 뒤에 새 더미
        while (s <= e) {
            int m = (s + e) / 2;
            // mount[m]의 마지막 원소
            int lastVal = mount.get(m).get(mount.get(m).size() - 1);
            if (h <= lastVal) {
                idx = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return idx;
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int Q = sc.nextInt();  // 명령어 개수
        
        for (int _q = 0; _q < Q; _q++) {
            int cmd = sc.nextInt();
            switch(cmd) {
                case 100:
                    // 빅뱅: 기존 데이터 초기화 후
                    // n개의 산 높이를 입력받아 차례대로 insert
                    mount.clear();
                    indexArr.clear();
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        int h = sc.nextInt();
                        int idx = search(h);
                        // 만약 idx == mount.size() 면 새 더미 추가
                        if (idx == mount.size()) {
                            mount.add(new ArrayList<>());
                        }
                        mount.get(idx).add(h);
                        indexArr.add(idx);
                    }
                    break;
                    
                case 200:
                    // 우공이산: 산 1개 추가
                    {
                        int h = sc.nextInt();
                        int idx = search(h);
                        if (idx == mount.size()) {
                            mount.add(new ArrayList<>());
                        }
                        mount.get(idx).add(h);
                        indexArr.add(idx);
                    }
                    break;
                    
                case 300:
                    // 지진: 가장 오른쪽 산 제거
                    {
                        // indexArr의 마지막 => 그 더미에서 마지막 산 제거
                        int lastIdx = indexArr.get(indexArr.size() - 1);
                        indexArr.remove(indexArr.size() - 1);
                        
                        List<Integer> pile = mount.get(lastIdx);
                        pile.remove(pile.size() - 1);
                        
                        // 만약 그 더미가 비었다면 mount에서도 제거
                        if (mount.get(mount.size() - 1).isEmpty()) {
                            mount.remove(mount.size() - 1);
                        }
                    }
                    break;
                    
                case 400:
                    // 등산 시뮬레이션
                    {
                        int m_index = sc.nextInt();
                        // 1-based -> 0-based
                        m_index--;
                        int pileIndex = indexArr.get(m_index);
                        
                        // 점수 계산
                        // (pileIndex + mount.size()) * 1,000,000 + (mount의 마지막 더미의 첫 원소)
                        int score = (pileIndex + mount.size()) * 1_000_000;
                        if (!mount.isEmpty()) {
                            // 마지막 더미의 첫 번째 산 높이
                            List<Integer> lastPile = mount.get(mount.size() - 1);
                            int val = lastPile.get(0);
                            score += val;
                        }
                        System.out.println(score);
                    }
                    break;
            }
        }
    }
    
    // 입력 속도 개선용 클래스
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
