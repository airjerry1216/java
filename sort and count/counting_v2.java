import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class counting_v2
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
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator.next();
            System.out.printf("%s : %d\n",entry.getKey(),entry.getValue());
        }
    }
}