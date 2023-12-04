import java.util.*;

public class Main {
    public static final int INFO_MAX = 100;
    public static char[][] arr2D = new char[INFO_MAX][2];
    public static boolean[] developer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        developer = new boolean[n];
        for(int i = 0 ; i < m ; i++){
            arr2D[i][0] = sc.next().charAt(0);
            arr2D[i][1] = sc.next().charAt(0);
        }

        // 이후에 글 작성한 사람들은 위에 있는 글을 볼 수가 있음.
        for(int i = n - 1 ; i >= p - 1; i--){
            developer[arr2D[i][0] - 'A'] = true;
        }

        // 0이면 다 읽었다는 뜻.
        if(arr2D[p-1][1] == '0'){
            Arrays.fill(developer, true);
        }
        else{
            // 읽지 않다는 사람이 같다는건 위에 보낸 사람이 나가지 않았다는 뜻.
            for(int i = p - 2 ; i >= 0 ; i--){
                if(arr2D[i][1] == arr2D[i+1][1]){
                    developer[arr2D[i][0] - 'A'] = true;
                }
                else{
                    break;
                }
            }
        }


        char output = 'A';
        for(int i = 0 ; i < developer.length ; i++){
            if(!developer[i]){
                System.out.print(output + " ");
            }
            output = (char) (output + 1);
        }
    }
}