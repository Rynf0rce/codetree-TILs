import java.util.*;

public class Main {
    public static boolean conFnc(Stack vector, String str){
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '('){
                vector.push('(');
            }
            else{
                if(vector.isEmpty()){
                    return false;
                }
                vector.pop();
            }
        }

        if(!vector.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> vector = new Stack<>();
        String str = sc.next();
        System.out.println(conFnc(vector, str) ? "Yes" : "No");
    }
}