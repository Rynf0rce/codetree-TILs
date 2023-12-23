import java.util.*;

public class Main {
    public static final int MAX_INTEGER = 4;
    public static char[] equation;
    public static ArrayList<Character> spell = new ArrayList<>();
    public static ArrayList<Integer> valueVector = new ArrayList<>();
    public static int maxVal = Integer.MIN_VALUE;

    public static int matchValue(char c){
        int spellIdx = spell.indexOf(c);
        return valueVector.get(spellIdx);
    }

    public static int operation(int preNum, char oper, int postNum){
        int output = 0;
        switch(oper){
            case '+' :
                output = preNum + postNum;
                break;
            case '-' :
                output = preNum - postNum;
                break;
            case '*' :
                output = preNum * postNum;
                break;
        }
        return output;
    }

    public static int calculation(){
        int preNum = matchValue(equation[0]);
        char oper = ' ';
        int postNum = 0;
        for(int i = 1 ; i < equation.length ; i++){
            if(equation[i] >= 'a'){
                postNum = matchValue(equation[i]);
                preNum = operation(preNum, oper, postNum);
            }
            else{
                oper = equation[i];
            }
        }
        return preNum;
    }

    public static void setValue(int num){
        if(num > 4){
            return;
        }

        if(valueVector.size() >= spell.size()){
            maxVal = Math.max(maxVal, calculation());
            return;
        }

        for(int i = 1 ; i <= MAX_INTEGER ; i++){
            valueVector.add(i);
            setValue(num + 1);
            valueVector.remove(valueVector.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        equation = sc.next().toCharArray();
        for(int i = 0 ; i < equation.length ; i++){
            if(equation[i] >= 'a' && !spell.contains(equation[i])){
                spell.add(equation[i]);
            }
        }
        Collections.sort(spell);

        setValue(1);

        System.out.println(maxVal);
    }
}