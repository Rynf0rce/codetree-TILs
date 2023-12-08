import java.util.*;

public class Main {
    public static LinkedList<Character> vector = new LinkedList<>();
    public static ListIterator<Character> it;
    public static void conFnc(char order, char input){
        switch(order){
            case 'L' :
                if(it.hasPrevious()){
                    it.previous();
                }
                break;
            case 'R' :
                if(it.hasNext()){
                    it.next();
                }
                break;
            case 'D' :
                if(it.hasNext()){
                    it.next(); // remove는 바로 앞에 있는 빵을 제거하기 때문에.
                    it.remove(); // 위의 조건을 맞추기 위해 한칸 앞으로 이동해서 빼면 성립함.
                }
                break;
            case 'P' :
                it.add(input);
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        for(int i = 0 ; i < n ; i++){
            vector.add(arr[i]);
        }
        it = vector.listIterator(vector.size());
        for(int i = 0; i < m ; i++){
            char order = sc.next().charAt(0);
            char input = ' ';
            if(order == 'P'){
                input = sc.next().charAt(0);
            }
            conFnc(order, input);
        }
        ListIterator<Character> output = vector.listIterator();
        while(output.hasNext()){
            System.out.print(output.next());
        }
    }
}