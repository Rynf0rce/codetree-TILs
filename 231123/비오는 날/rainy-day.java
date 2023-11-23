import java.util.*;

class forecast{
        String date;
        String day;
        String weather;

        public forecast(String date, String day, String weather){
            this.date = date;
            this.day = day;
            this.weather = weather;
        }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        forecast[] arr = new forecast[num];
        int idx = -1;
        for(int i = 0 ; i < arr.length ; i++){
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            arr[i] = new forecast(date, day, weather);
            if(arr[i].weather.equals("Rain")){
                if(idx == -1){
                    idx = i;
                }
                else{
                    if(arr[idx].date.compareTo(arr[i].date) > 0 ){
                        idx = i;
                    }
                }
            }
        }

        System.out.printf("%s %s %s",arr[idx].date, arr[idx].day, arr[idx].weather);

    }
}