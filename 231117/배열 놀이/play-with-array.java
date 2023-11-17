import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfElement = sc.nextInt();
        int numOfQuestion = sc.nextInt();
        int[] arr = new int[numOfElement];
        int question = 0, a = 0, b = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < numOfQuestion ; i++){
            question = sc.nextInt();
            switch(question){
                case 1 :
                    a = sc.nextInt();
                    System.out.println(arr[a-1]);
                    break;
                case 2 :
                    a = sc.nextInt();
                    for(int j = 0 ; j < arr.length ; j++){
                        if(arr[j] == a){
                            System.out.println(j + 1);
                            break;
                        }
                    }
                    System.out.println(0);
                    break;
                case 3 :
                    a = sc.nextInt();
                    b = sc.nextInt();
                    for(int j = a - 1 ; j < b ; j++){
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}