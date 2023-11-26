import java.util.*;

class developer{
    boolean infected;
    int vaildHandshake;

    developer(){
        this.infected = false;
        this.vaildHandshake = 0;
    }

    developer(boolean infected, int vaildHandshake){
        this.infected = infected;
        this.vaildHandshake = vaildHandshake;
    }
}

class tasks implements Comparable<tasks>{
    int time;
    int x_dev;
    int y_dev;

    tasks(){}

    tasks(int time, int x_dev, int y_dev){
        this.time = time;
        this.x_dev = x_dev;
        this.y_dev = y_dev;
    }
    
    @Override
    public int compareTo(tasks input){
        return this.time - input.time;
    }
}

public class Main {
    public static final int MAX_NUMOFDEVELOPER = 100;
    public static final int MAX_VAILDTIME = 250;
    public static final int MAX_TASKS = 250;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n k p t
        int peoples = sc.nextInt(), vaildHandshake = sc.nextInt(), infected = sc.nextInt(), numOfTask = sc.nextInt();
        developer[] devList = new developer[MAX_NUMOFDEVELOPER + 1];
        for(int i = 1 ; i <= peoples ; i++){
            if(i == infected){
                devList[i] = new developer(true, vaildHandshake);
            }
            else{
                devList[i] = new developer();
            }
        }
        tasks[] taskList = new tasks[MAX_TASKS + 1];
        for(int i = 0 ; i < numOfTask ; i++){
            int time = sc.nextInt();
            int x_dev = sc.nextInt();
            int y_dev = sc.nextInt();
            taskList[i] = new tasks(time, x_dev, y_dev);
        }
        
        Arrays.sort(taskList, 0, numOfTask);

        for(int i = 0 ; i < numOfTask ; i++){
            int x_dev = taskList[i].x_dev;
            int y_dev = taskList[i].y_dev;
            boolean x_task = false, y_task = false;
            if(devList[x_dev].infected && devList[x_dev].vaildHandshake > 0){
                x_task = true;
                devList[x_dev].vaildHandshake--;
            }
            if(devList[y_dev].infected && devList[y_dev].vaildHandshake > 0){
                y_task = true;
                devList[y_dev].vaildHandshake--;
            }

            if(x_task && devList[y_dev].infected == false){
                devList[y_dev].infected = true;
                devList[y_dev].vaildHandshake = vaildHandshake;
            }
            else if(y_task && devList[x_dev].infected == false){
                devList[x_dev].infected = true;
                devList[x_dev].vaildHandshake = vaildHandshake;
            }
        }

        for(int i = 1 ; i <= peoples ; i++){
            System.out.print(devList[i].infected ? 1 : 0);
        }
        
    }
}