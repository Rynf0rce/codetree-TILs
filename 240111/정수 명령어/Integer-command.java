import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s = new TreeSet<>();
        int T = sc.nextInt();
        for(int i = 0 ; i < T ; i++){
            int k = sc.nextInt();
            s.clear();
            for(int j = 0 ; j < k ; j++){
                char spell = sc.next().charAt(0);
                int val = 0;
                switch(spell){
                    case 'I' :
                        val = sc.nextInt();
                        s.add(val);
                        break;
                    case 'D' :
                        val = sc.nextInt();
                        if(s.isEmpty()){
                            break;
                        }

                        if(val < 0){
                            s.remove(s.first());
                        }
                        else{
                            s.remove(s.last());
                        }
                        break;
                }
            }

            if(s.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.printf("%d %d\n", s.last(), s.first());
            }
        }
    }
}