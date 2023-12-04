import java.util.*;

public class Main {
    public static final int MAX_VELOCITY = 100;
    public static int[] velocityArr = new int[101];
    public static int costOfVelocity(int velocity){
        return velocity * velocity;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int maxVelocity = 0;
        for(int i = 1 ; i <= MAX_VELOCITY; i++){
            if(X >= costOfVelocity(i)){
                maxVelocity++;
            }
        }

        for(int i = 1 ; i <= maxVelocity ; i++){
            if(i != maxVelocity){
                velocityArr[i] += 2;
            }
            else{
                velocityArr[i]++;
            }
        }

        int currentDistance = X - costOfVelocity(maxVelocity);

        for(int i = maxVelocity ; i >= 1 ; i--){
            int quotient = currentDistance / i;
            velocityArr[i] += quotient;
            currentDistance = currentDistance % i;
        }

        int output = 0;

        for(int i = 1 ; i <= maxVelocity ; i++){
            output += velocityArr[i];
        }

        System.out.println(output);
    }
}