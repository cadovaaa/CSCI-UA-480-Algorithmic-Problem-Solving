import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        TreeSet<String> dictionary = new TreeSet<>();
        int count = 0;
        while (in.hasNext()){
            String curr = in.next().toLowerCase();
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < curr.length(); i++){
                if (curr.charAt(i) > 96 && curr.charAt(i) < 123){
                    sb.append(curr.charAt(i));
                } else if (sb.length() > 0){
                    dictionary.add(sb.toString());
                    sb.setLength(0);
                    count ++;
                }
            }
            if (sb.length() > 0){
                dictionary.add(sb.toString());
                sb.setLength(0);
                count ++;
            }
        }

        int size = dictionary.size();
        for (int i = 0; i < size; i++){
            System.out.println(dictionary.pollFirst());
        }
    }
}
