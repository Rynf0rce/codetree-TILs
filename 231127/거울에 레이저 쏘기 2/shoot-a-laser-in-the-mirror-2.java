import java.util.*;

class coordinate{
    int row;
    int column;
    int direction;

    coordinate(){
        this.row = 0;
        this.column = 0;
        this.direction = 0;
    }
    
    coordinate(int row, int column, int direction){
        this.row = row;
        this.column = column;
        this.direction = direction;
    }
}

public class Main {
    public static coordinate setPoint(int num, int edge){
        int quotient = (num - 1) / edge;
        int remainder = (num - 1) % edge;
        coordinate output = new coordinate();
        // System.out.println("q&r : " + quotient + " " + remainder);
        switch(quotient){
            case 0 :
                output.row = 0;
                output.column = remainder;
                output.direction = 0;
                break;
            case 1 :
                output.row = remainder;
                output.column = edge - 1;
                output.direction = 1;
                break;
            case 2 :
                output.row = edge - 1;
                output.column = edge - remainder - 1;
                output.direction = 2;
                break;
            case 3 :
                output.row = edge - remainder - 1;
                output.column = 0;
                output.direction = 3;
            break;  
        }
        return output;
    }

    public static coordinate move(boolean[][] arr2D, coordinate currentPoint){
        int[] arrRow = {-1, 0 , 1, 0};
        int[] arrColumn = {0, 1, 0 , -1};
        coordinate temp = new coordinate(currentPoint.row, currentPoint.column, currentPoint.direction);
        // System.out.println("row : " + temp.row + " column : " + temp.column);
        // "/" 인 경우
        if(arr2D[temp.row][temp.column]){
            // System.out.println("chack 0 " + temp.direction);
            temp.direction = Math.abs(3 - temp.direction); 
        }
        // "\"인 경우
        else{
            if(temp.direction == 0 || temp.direction == 2){
                // System.out.println("chack a " + temp.direction);
                temp.direction++;
            }
            else{
                // System.out.println("chack b " + temp.direction);
                temp.direction--;
            }
        }
        
        temp.row += arrRow[temp.direction];
        temp.column += arrColumn[temp.direction];
        temp.direction = (temp.direction + 2) % 4;

        // System.out.println("final " + temp.row + " " + temp.column + " " + temp.direction);

        return temp;   
    }

    public static boolean inRange(int length, int row, int column){
        if(row >= 0 && column >= 0 && row <= length -1 && column <= length -1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        int edge = sc.nextInt();
        boolean[][] arr2D = new boolean[edge][edge];
        for(int i = 0 ; i < edge ; i++){
            String str = sc.next();
            for(int j = 0 ; j < edge ; j++){
                if(str.charAt(j) == '/'){
                    arr2D[i][j] = true;
                }
                else{
                    arr2D[i][j] = false;
                }
                
            }
        }

        int num = sc.nextInt(), cnt = 1;
        coordinate currentPoint = setPoint(num,edge);
        while(true){
            currentPoint = move(arr2D,  currentPoint);
            // System.out.println(currentPoint.row + " " + currentPoint.column + " " + currentPoint.direction);
            if(!inRange(arr2D.length, currentPoint.row, currentPoint.column)){
                break;
            }
            else{
                cnt++;
            }
        }
        System.out.println(cnt);
        
     
        
    }
}