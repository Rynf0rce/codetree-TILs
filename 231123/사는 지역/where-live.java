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

        System.out.println("name " + arr[idx].name);
        System.out.println("addr " + arr[idx].address);
        System.out.println("city " + arr[idx].city);     
    }
}