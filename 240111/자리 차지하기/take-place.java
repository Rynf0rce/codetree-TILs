import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> s = new TreeSet<>();
        
        // 사람이 자리에 앉아 있다고 가정하자.
        for(int i = 1 ; i <= m ; i++){
            s.add(i);
        }

        for(int i = 0 ; i < n ; i++){
            // num = a_i (1 ~ i)까지 앉아 있는 사람중 아무나 일으키게 해주세요.
            int num = sc.nextInt();

            if(s.contains(num)){
                s.remove(num);  // 그 자리에 앉아있는 경우
            }
            else if(s.lower(num) != null){
                s.remove(s.lower(num)); // 그 자리를 기준으로 가장 가까이에 앉아 있는 사람을 일으킨다.
            }
            else{
                break;
            }
        }

        // 문제에서는 사람을 앉히는 문제이기 때문에 나간사람의 수가 정답이 된다.
        // 따라서 전체 의자수 - 남아 있는 수
        System.out.println(m - s.size());
        
    }
}