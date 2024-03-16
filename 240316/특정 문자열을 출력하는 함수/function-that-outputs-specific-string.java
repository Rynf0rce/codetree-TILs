import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void addString(){
        sb.append("Hello\n#@#@#@#@#@\nCodeTree\n@#@#@#@#@#\nStudents!\n\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            addString();
        }
        System.out.print(sb.toString());
    }
}