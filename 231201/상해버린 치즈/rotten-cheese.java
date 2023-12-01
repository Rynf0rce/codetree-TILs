import java.util.*;

class schedule implements Comparable<schedule>{
    int eater;
    int time;
    int cheese;

    schedule(){}

    schedule(int eater, int time, int cheese){
        this.eater = eater;
        this.time = time;
        this.cheese = cheese;
    }

    @Override
    public int compareTo(schedule input){
        if(this.time == input.time){
            return this.eater - input.eater;
        }
        else{
            return this.time - input.time;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), D = sc.nextInt(), S = sc.nextInt(), pill = 0;
        boolean[] manArr = new boolean[N+1];
        boolean[] cheeseArr = new boolean[M+1];
        schedule[] timeArr = new schedule[D];
        schedule[] sickArr = new schedule[S];
        for(int i = 0; i < timeArr.length ; i++){
            int eater = sc.nextInt();
            int cheese = sc.nextInt();
            int time = sc.nextInt();
            timeArr[i] = new schedule(eater, time, cheese);
        }

        Arrays.sort(timeArr);
        // for(int i = 0 ; i < timeArr.length ; i++){
        //     System.out.printf("%d %d %d\n", timeArr[i].time, timeArr[i].eater, timeArr[i].cheese);
        // }

        for(int i = 0; i < sickArr.length ; i++){
            int eater = sc.nextInt();
            int cheese = 0;
            int time = sc.nextInt();
            sickArr[i] = new schedule(eater, time, cheese);
        }

        Arrays.sort(sickArr);

        // for(int i = 0 ; i < sickArr.length ; i++){
        //     System.out.printf("%d %d %d\n", sickArr[i].time, sickArr[i].eater, sickArr[i].cheese);
        // }
        
        int targetCheese = 0;
        for(int i = 1 ; i < cheeseArr.length ; i++){
            int cnt = 0;
            for(int j = 0 ; j < timeArr.length ; j++){
                if(timeArr[j].cheese == i){
                    for(int k = 0 ; k < sickArr.length ; k++){
                        if(timeArr[j].eater == sickArr[k].eater && sickArr[k].time > timeArr[j].time + 1){
                            cnt++;
                            //System.out.println("What cheese? : " + i);
                            //cheeseArr[i] = true;
                        }
                    }
                    if(cnt == sickArr.length){
                        // System.out.println("What cheese? : " + i);
                        cheeseArr[i] = true;
                    }
                }
            }
        }

        for(int i = 0 ; i < timeArr.length ; i++){
            for(int j = 1 ; j < cheeseArr.length ; j++){
                if(timeArr[i].cheese == j && cheeseArr[j]){
                    manArr[timeArr[i].eater] = true;
                }
            }
        }

        for(int i = 1 ; i < manArr.length ; i++){
            if(manArr[i]){
                pill++;
            }
        }
        System.out.println(pill);
    }
}