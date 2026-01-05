import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        
        Stack<Character> parens = new Stack<>();
        Map<Character,Character> dict = new HashMap<>();
        dict.put('}','{');
        dict.put(']','[');
        dict.put(')','(');
        
        char character;
        for (int i = 0; i<line.length(); i++){
            character = line.charAt(i);
            if (character == '{' || character == '[' || character == '('){
                parens.push(character);
            } else if (character == '}' || character == ']' || character == ')'){
                if (parens.isEmpty() || parens.pop() != dict.get(character)){
                    System.out.println("NO " + (i+1));
                    return;
                }
            }
        }
        if (!parens.isEmpty()){
            System.out.println("NO " + (line.length()+1));
            return;
        }
        System.out.println("YES");
    }
}
