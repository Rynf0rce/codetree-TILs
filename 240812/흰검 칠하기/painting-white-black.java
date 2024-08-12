import java.util.*;

class idxColor{
    char color;
    int Lcount;
    int Rcount;

    idxColor(){}

    idxColor(char color){
        this.color = color;
        this.Lcount = 0;
        this.Rcount = 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), current = 100000, cnt = 0;
        idxColor[] arr = new idxColor[200001];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = new idxColor('N');
        }

        for(int i = 0 ; i < num ; i++){
            int step = sc.nextInt();
            char direct = sc.next().charAt(0);
            switch(direct){
                case 'R' :
                    for(int j = current ; j < current + step ; j++){
                        arr[j].Rcount++;
                        if(arr[j].Rcount > 1 && arr[j].Lcount > 1){
                            arr[j].color = 'A';
                        }
                        else{
                             arr[j].color = 'B';
                        }
                    }
                    current += (step - 1);
                    break;
                case 'L' :
                    for(int j = current ; j > current - step ; j--){
                        arr[j].Lcount++;
                        if(arr[j].Rcount > 1 && arr[j].Lcount > 1){
                            arr[j].color = 'A';
                        }
                        else{
                            arr[j].color = 'W';
                        }
                    }
                    current -= (step - 1);
                    break;
                default :
                    break;
            }
        }
        int white = 0;
        int black = 0;
        int ash = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i].color == 'W'){
                white++;
            }
            else if(arr[i].color == 'B'){
                black++;
            }
            else if(arr[i].color == 'A'){
                ash++;
            }
        }
        System.out.printf("%d %d %d", white, black, ash);
    }
}