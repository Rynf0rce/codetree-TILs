import java.util.*;

class info{
    String name;
    String address;
    String city;

    public info(String name, String address, String city){
        this.name = name;
        this.address = address;
        this.city = city;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        info[] arr = new info[num];
        int idx = 0;
        for(int i = 0 ; i < arr.length ; i++){
            String name = sc.next();
            String address = sc.next();
            String city = sc.next();
            arr[i] = new info(name, address, city);
        }
        
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].name.length() ; j++){
                try{
                    if(arr[idx].name.charAt(j) < arr[i].name.charAt(j)){
                    idx = i;
                    break;
                    }
                    else if(arr[idx].name.charAt(j) > arr[i].name.charAt(j)){
                        break;
                    }
                } catch(StringIndexOutOfBoundsException e) {
                    if(arr[idx].name.length() < arr[i].name.length()){
                        idx = i;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        /*
        // comparTo는 같은 위치의 문자만 비교하기 때문에, 
        // 첫번째 문자부터 순서대로 비교해서 다를 경우 바로 아스키값을 기준으로 비교처리를 한다.
        // 기준값에 비교대상이 포함될 경우 문자열의 길이 값을 리턴
        // ex) abcd.compareTo(ab) -> 2 / abcd.compareTo(c) -> -2
        int lastIdx = 0;
        for(int i = 1; i < n; i++) {
            if(people[i].name.compareTo(people[lastIdx].name) > 0)  
                lastIdx = i;
        }
        */



        System.out.println("name " + arr[idx].name);
        System.out.println("addr " + arr[idx].address);
        System.out.println("city " + arr[idx].city);     
    }
}