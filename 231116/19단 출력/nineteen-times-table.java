public class Main {
    public static void main(String[] args) {
        for(int i = 1 ; i <= 19 ; i++){
            for(int j = 1 ; j <= 19; j++){
                System.out.printf("%d * %d = %d", i, j, i*j);
                if(j % 2 == 0 || j == 19){
                    System.out.println();
                }
                else{
                    System.out.print(" / ");
                }
            }
        }
    }
}