import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static ArrayList<String> strList = new ArrayList<>();

    public static int matching(String str){
        int output = 0;
        char[] inputArr = str.toCharArray();
        int[] leftArr = new int[inputArr.length + 1];

        for(int i = inputArr.length - 1; i >= 0 ; i--){
            leftArr[i] = leftArr[i + 1];
            if(inputArr[i] == ')'){
                leftArr[i]++;
            }
        }

        for(int i = 0 ; i < inputArr.length ; i++){
            if(inputArr[i] == '('){
                output += leftArr[i + 1];
            }
        }

        return output;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            strList.add(br.readLine());
            // System.out.println(strList.get(i));
        }

        // System.out.println(matching("(())"));

        Collections.sort(strList, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(matching(a.concat(b)) > matching(b.concat(a))){
                    return 1;
                }
                else if(matching(a.concat(b)) == matching(b.concat(a))){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        });

        // System.out.println();
        String ans = "";
        for(int i = n - 1 ; i >= 0 ; i--){
            ans += strList.get(i);
            // System.out.println(strList.get(i));
        }

        // System.out.println(ans);
        System.out.println(matching(ans));

    }
}