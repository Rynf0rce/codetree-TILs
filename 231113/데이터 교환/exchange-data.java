public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int a = 5, b = 6, c= 7, temp = b;
        b = a;
        a = c;
        c = temp;
        System.out.print(a + "\n" + b + "\n" + c );
    }
}