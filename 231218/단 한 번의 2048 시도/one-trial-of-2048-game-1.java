import java.util.*;

public class Main {
    public static int[][] area = new int[4][4];
    public static void gravity(char dir){
        int[][] temp = new int[4][4];
        switch(dir){
            case 'L' :
                for(int i = 0 ; i < 4 ; i++){
                    int idx = 0;
                    int value = 0;
                    for(int j = 0 ; j < 4 ; j++){
                        if(area[i][j] != 0){
                            if(value != area[i][j]){
                                value = area[i][j];
                                temp[i][idx++] = area[i][j];
                            }
                            else{
                                temp[i][--idx] = value * 2;
                                idx++;
                                value = 0;
                            }
                        }
                    }
                }
                break;
            case 'R' :
                for(int i = 0 ; i < 4 ; i++){
                    int idx = 3;
                    int value = 0;
                    for(int j = 3 ; j >= 0 ; j--){
                        if(area[i][j] != 0){
                            if(area[i][j] != 0){
                                if(value != area[i][j]){
                                    value = area[i][j];
                                    temp[i][idx--] = area[i][j];
                                }
                                else{
                                    temp[i][++idx] = value * 2;
                                    idx--;
                                    value = 0;
                                }
                            }
                        }
                    }
                }
                break;
            case 'U' :
                for(int i = 0 ; i < 4 ; i++){
                    int idx = 0;
                    int value = 0;
                    for(int j = 0 ; j < 4 ; j++){
                        if(area[j][i] != 0){
                            if(area[j][i] != 0){
                                if(value != area[j][i]){
                                    value = area[j][i];
                                    temp[idx++][i] = area[j][i];
                                }
                                else{
                                    temp[--idx][i] = value * 2;
                                    idx++;
                                    value = 0;
                                }
                            }
                        }
                    }
                }
                break;
            case 'D' :
                for(int i = 0 ; i < 4 ; i++){
                    int idx = 3;
                    int value = 0;
                    for(int j = 3 ; j >= 0 ; j--){
                        if(area[j][i] != 0){
                            if(value != area[j][i]){
                                temp[idx--][i] = area[j][i];
                                value = area[j][i];
                            }
                            else{
                                temp[++idx][i] = value * 2;
                                idx--;
                                value = 0;
                            }
                        }
                    }
                }
                break;
        }

        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                area[i][j] = temp[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                area[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);

        gravity(dir);

        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
    }
}
