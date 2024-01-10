import java.util.*;

public class Main {
    public static final int MAX_PAPER = 500;
    public static final int MAX_SPELL = 50;
    
    public static char[][] tableA = new char[MAX_PAPER][MAX_SPELL];
    public static char[][] tableB = new char[MAX_PAPER][MAX_SPELL];

    public static HashSet<String> groupA = new HashSet<>();
    public static HashSet<String> groupB = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            for(int j = 0 ; j < str.length() ; j++){
                tableA[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            for(int j = 0 ; j < str.length() ; j++){
                tableB[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for(int i = 0 ; i < M - 2 ; i++){
            for(int j = i + 1 ; j < M - 1 ; j++){
                for(int k = j + 1 ; k < M ; k++){
                    groupA.clear();
                    groupB.clear();
                    for(int h = 0 ; h < N ; h++){
                        String strA = "" + tableA[h][i] + tableA[h][j] + tableA[h][k];
                        String strB = "" + tableB[h][i] + tableB[h][j] + tableB[h][k];
                        groupA.add(strA);
                        groupB.add(strB);
                    }

                    Iterator<String> iter = groupA.iterator();
                    boolean chack = true;

                    while(iter.hasNext()){
                        String str = iter.next();
                        if(groupB.contains(str)){
                            chack = false;
                            break;
                        }
                    }

                    if(chack){
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}