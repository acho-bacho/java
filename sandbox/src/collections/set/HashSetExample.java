package collections.set;
import java.util.*;
public class HashSetExample {
    public static void main(String args[]) {
        //Creating HashSet and adding elements  
        HashSet<String> set = new HashSet<String>();
        set.add("AAA");
        set.add("BBB");
        set.add("CCC");
        set.add("ABA");
        set.add("ABA"); //dupl
        set.add(new String("ABA"));
        //Traversing elements  
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
