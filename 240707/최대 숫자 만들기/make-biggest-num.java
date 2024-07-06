import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<String> inputList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            inputList.add(br.readLine());
        }


        Collections.sort(inputList, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                long n1 = Long.parseLong(a.concat(b));
                long n2 = Long.parseLong(b.concat(a));

                if(n1 > n2){
                    return 1;
                }
                else{
                    return -1;
                }
                
            }
        });


        String ans = "";
        for(int i = n - 1 ; i >= 0 ; i--){
            String str = inputList.get(i);
            //System.out.println(str);
            bw.write(str);
            // ans.concat();
        }

        

        br.close();
        bw.close();


    }
}