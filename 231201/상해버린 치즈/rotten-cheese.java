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

        for(int i = 0; i < sickArr.length ; i++){
            int eater = sc.nextInt();
            int cheese = 0;
            int time = sc.nextInt();
            sickArr[i] = new schedule(eater, time, cheese);
        }

        Arrays.sort(sickArr);


        // 문제 치즈 하나씩 검사.
        for(int i = 1 ; i < cheeseArr.length ; i++){
            // sickArr의 조건을 세는변수.
            int cnt = 0;
            // 어떤 치즈를 먹었는지 모두 검사 의심 치즈를 먹었을 경우 조건에 부합한지 검사.
            for(int j = 0 ; j < timeArr.length ; j++){
                if(timeArr[j].cheese == i){
                    for(int k = 0 ; k < sickArr.length ; k++){
                        if(timeArr[j].eater == sickArr[k].eater && sickArr[k].time >= timeArr[j].time + 1){
                            cnt++;
                        }
                    }
                    if(cnt == sickArr.length){
                        cheeseArr[i] = true;
                    }
                }
            }
        }

        // 의심 치즈가 1개 일수도 있지만 여러개 일 수 있기에 의심 치즈를 먹은 사람을 체크.
        for(int i = 0 ; i < timeArr.length ; i++){
            for(int j = 1 ; j < cheeseArr.length ; j++){
                if(timeArr[i].cheese == j && cheeseArr[j]){
                    manArr[timeArr[i].eater] = true;
                }
            }
        }

        // 의심 치즈 먹은 사람의 수 검사 (중복해서 먹은 경우가 있을 수 있기 때문에 boolean 배열로 마지막에 검사.)
        for(int i = 1 ; i < manArr.length ; i++){
            if(manArr[i]){
                pill++;
            }
        }
        System.out.println(pill);
    }
}