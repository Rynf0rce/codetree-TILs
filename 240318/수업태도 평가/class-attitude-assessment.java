import java.util.*;
import java.io.*;

class tuple implements Comparable<tuple>{
    String name;
    int point;
    public tuple(String name, int point){
        this.name = name;
        this.point = point;
    }

    @Override
    public int compareTo(tuple t){
        return this.point - t.point;
    }
}

public class Main {
    public static HashMap<String, Integer> infoMap = new HashMap<>();
    public static String[] nameArr = new String[]{"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
    public static tuple[] ansArr = new tuple[7];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0 ; i < nameArr.length ; i++){
            infoMap.put(nameArr[i], 0);
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = String.valueOf(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            infoMap.put(name, infoMap.get(name) + point);
        }

        int idx = 0;
        for(Map.Entry<String, Integer> element : infoMap.entrySet() ){
            ansArr[idx++] = new tuple(element.getKey(), element.getValue());
        }

        Arrays.sort(ansArr);

        tuple minTuple = ansArr[0];
        tuple ansTuple = null;
        boolean flag = true;
        for(int i = 1 ; i < ansArr.length ; i++){
            if(minTuple.point == ansArr[i].point){
                continue;
            }

            if(ansTuple == null){
                ansTuple = ansArr[i];
            }
            else{
                if(ansTuple == ansArr[i]){
                    flag = false;
                }
                
                break;
            }
        }

        System.out.print(flag ? ansTuple.name : "Tie");
    }
}