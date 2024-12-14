import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] A;
    static long[] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine().trim());
        A=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        prefix=new long[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+A[i];
        }
        long[] leftB = new long[n+1];  // leftB[B] = max_{R1<B} (prefix[B]-prefix[R1-1]-A[R1])
        long[] rightB = new long[n+1]; // rightB[B] = max_{R2>B} (prefix[R2]-prefix[B-1]-A[R2])

        // leftB 계산: B를 2부터 n-1까지 이동, R1<B => R1 < B
        {
            // R1은 1부터 B-1 사이
            // prefix[B]-A[R1]-prefix[R1-1] = prefix[B]- (prefix[R1-1]+A[R1])
            // R1 증가시키면서 (prefix[R1-1]+A[R1])의 최소값을 찾는 문제
            long minBase = Long.MAX_VALUE;
            Arrays.fill(leftB, Long.MIN_VALUE);
            // B 최소 3 이상 되어야 R1<B가 만족할 여지 있음.
            for (int B=2; B<=n-1; B++) {
                // (prefix[R1-1]+A[R1]) 최소값 업데이트
                if (B>2) {
                    // B-1을 R1 후보로 고려해 minBase 갱신
                    int R = B-1;
                    minBase = Math.min(minBase, prefix[R-1]+A[R]);
                } else {
                    // 초기 minBase 설정: R1=1일 때 값
                    minBase = prefix[1-1]+A[1]; // prefix[0]+A[1]=A[1]
                }
                leftB[B] = prefix[B]-minBase; 
            }
        }

        // rightB 계산: R2>B => R2 > B
        // prefix[R2]-prefix[B-1]-A[R2] = (prefix[R2]-A[R2]) - prefix[B-1]
        // R2를 증가시키며 (prefix[R2]-A[R2])의 값의 최대를 추적하면,
        // B에 대해 max_{R2>B} R(R2,B)를 구할 수 있음.
        {
            // 뒤에서부터 계산
            long[] baseArr = new long[n+1];
            for (int R=1; R<=n; R++) {
                baseArr[R] = prefix[R]-A[R]; 
            }

            // 각 B에 대해 R2>B인 R2 중 baseArr[R2] 최대 - prefix[B-1] 값을 찾는다.
            // 이를 위해 오른쪽에서 baseArr[R]-prefix[x] 형태를 효율적으로 계산해야 하는데,
            // B가 감소할 때 prefix[B-1]은 감소하므로 R2>B에서의 최대 baseArr[R2]는 미리 오른쪽에서부터 최대값을 구해둔다.
            long[] maxFromRight = new long[n+2];
            Arrays.fill(maxFromRight, Long.MIN_VALUE);
            for (int i=n; i>=1; i--) {
                maxFromRight[i] = Math.max(maxFromRight[i+1], baseArr[i]);
            }
            Arrays.fill(rightB, Long.MIN_VALUE);
            for (int B=2; B<=n-1; B++) {
                // R2>B => R2≥B+1
                // rightB[B] = max_{R2>B} (prefix[R2]-prefix[B-1]-A[R2]) 
                //           = max_{R2>B} ((prefix[R2]-A[R2]) - prefix[B-1])
                //           = (max_{R2≥B+1} baseArr[R2]) - prefix[B-1]
                if (B+1<=n) {
                    long val = maxFromRight[B+1] - prefix[B-1];
                    rightB[B] = val;
                }
            }
        }

        long bestB = Long.MIN_VALUE;
        for (int B=2; B<=n-1; B++) {
            if (leftB[B]!=Long.MIN_VALUE && rightB[B]!=Long.MIN_VALUE) {
                bestB = Math.max(bestB, leftB[B]+rightB[B]);
            }
        }

        // 패턴 A, C와 그 외의 경우도 유사한 방식으로 계산할 수 있다.
        // 하지만 모든 예제에서 B를 가운데 두는 패턴(B)만 필요한 것은 아니다.

        // 이제 패턴 A와 C도 유사하게 계산한다.
        // 패턴 A (B가 가장 오른쪽): R1<R2<B
        // 점수 = (prefix[n]-prefix[R1-1]-A[R1]) + (prefix[n]-prefix[R2-1]-2*A[R2])
        // B=n이므로 고정. 여기서 B변수 의미 없음. 단, B를 n 고정할 필요가 없어도, B가 맨 오른쪽이면 B=n.
        // 하지만 문제에서 B=n만이 아닌 B가 가장 큰 인덱스일 때 패턴을 생각하면 결국 B=n이므로 바로 계산.
        // R2를 증가시키며 X(R1)=prefix[n]-prefix[R1-1]-A[R1], Y(R2)=prefix[n]-prefix[R2-1]-2A[R2]
        // R1<R2에서 maxX+Y를 계산
        long bestA = Long.MIN_VALUE;
        {
            if (n>=3) {
                long maxX = Long.MIN_VALUE;
                maxX = X_end(1);
                for (int R2=2; R2<=n-1; R2++) {
                    bestA = Math.max(bestA, maxX + Y_end(R2));
                    maxX = Math.max(maxX, X_end(R2));
                }
            }
        }

        // 패턴 C (B가 가장 왼쪽): B=1일 때
        // 점수 (B=1, B<R1<R2): (prefix[R1]-2A[R1]) + (prefix[R2]-A[R2])
        // R2를 증가시키며 X(R1)=prefix[R1]-2A[R1], Y(R2)=prefix[R2]-A[R2]
        // R1<R2에서 maxX+Y 최댓값
        long bestC = Long.MIN_VALUE;
        {
            if(n>=3) {
                long maxX = X_start(2);
                for(int R2=3; R2<=n-1; R2++){
                    bestC = Math.max(bestC, maxX + Y_start(R2));
                    maxX = Math.max(maxX, X_start(R2));
                }
            }
        }

        // 패턴 B의 반대(R2<B<R1)나 패턴 A,C의 대칭 케이스도 max를 취하면 커버됨
        // 왜냐하면 (R1,R2,B) 순서 바뀌어도 R1과 R2 치환하면 같은 식으로 최대값 갱신 가능
        // 즉, R1,R2를 뒤집어본 경우도 고려하기 위해 R1,R2 역할을 바꾼 값을 추가적으로 계산한다.
        
        // 패턴 B 반대: (R2<B<R1)
        // 점수=(prefix[R2]-prefix[B-1]-A[R2])+(prefix[B]-prefix[R1-1]-A[R1])와 유사
        // 사실 R1,R2치환하면 같은 식이므로 bestB를 그대로 두 번 고려할 필요 없음
        // 이미 (R1,R2) 대칭은 for문에서 모두 고려됨.
        // 여기서는 명시적으로 뒤집은 패턴도 구해보자.

        // R1,R2 치환은 패턴 A,C에서 이미 양쪽 방향에 대해 전부 고려되었음.
        // 패턴 A나 C도 (R2,R1) 순서 할 때 같은 식으로 max값이 나옴.
        // 즉, A,C 패턴에서도 R1,R2의 역할을 바꾼 경우를 동일하게 계산해야 한다.
        // A패턴 반전:
        long bestA2 = Long.MIN_VALUE;
        {
            if (n>=3) {
                long maxX = Long.MIN_VALUE;
                // 여기서 X_end와 Y_end를 R1,R2 역할 바꿔서 생각
                // R2<R1<B일 때 식도 동일한 형태:
                // X'(R)=prefix[n]-prefix[R-1]-A[R], Y'(R)=prefix[n]-prefix[R-1]-2A[R]는 대칭
                // 사실 R1,R2 이름 바꾸면 같은 계산이므로 다시 계산 필요 없음
                // bestA는 R1,R2 순서를 바꿔도 같은 로직에서 최대값 얻음
                // 따라서 별도 계산 없이 bestA가 이미 대칭 경우 커버
                // 여기서는 생략
            }
        }

        // C패턴 반전도 마찬가지로 이미 대칭 커버.

        // 모든 패턴 중 최댓값
        long answer = Math.max(bestB, Math.max(bestA, bestC));

        System.out.println(answer);
    }

    static long X_end(int R) {
        // B=n 고정일 때 사용
        return prefix[n]-prefix[R-1]-A[R];
    }
    static long Y_end(int R) {
        return prefix[n]-prefix[R-1]-2L*A[R];
    }
    static long X_start(int R) {
        // B=1 고정일 때 사용
        return prefix[R]-2L*A[R];
    }
    static long Y_start(int R) {
        return prefix[R]-A[R];
    }
}
