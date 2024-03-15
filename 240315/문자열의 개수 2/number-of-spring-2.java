import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<String> strList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = String.valueOf(br.readLine());
            if(str.equals("0")){
                break;
            }
            strList.add(str);
        }

        System.out.println(strList.size());
        for(int i = 1 ; i < strList.size() ; i += 2){
            System.out.println(strList.get(i));
        }
    }
}