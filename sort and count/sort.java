import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class sort
{
    public static void main(String[] args)
    {
        Map<String,Integer> map=new HashMap<String,Integer>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a tring :");
        String input=scanner.nextLine().toLowerCase();
        //System.out.print(str);
        String[] strings=input.split("[\\W]+");
        for(String str:strings)
        {
            //System.out.println(str);
            if(map.containsKey(str))
            {
                int count=map.get(str);
                map.put(str,count+1);
            }
            else
            {
                map.put(str,1);
            }
        }
        Set<String> keys=map.keySet();  //get keys
        TreeSet<String> sort=new TreeSet<>(keys);

        for(String str:sort)
        {
            System.out.println(str);
        }
    }
}