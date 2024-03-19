import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<Character, Integer> inMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = String.valueOf(br.readLine()).toCharArray();
        boolean[] visited = new boolean[arr.length];
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            char curSpell = arr[i];
            if(!inMap.containsKey(curSpell)){
                inMap.put(curSpell, i);
            }
            else{
                visited[inMap.get(curSpell)] = true;
                visited[i] = true;
                for(int j = inMap.get(curSpell) + 1 ; j < i ; j++){
                    if(!visited[j]){
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}