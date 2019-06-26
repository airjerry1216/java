import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class counting
{
    public static void main(String[] args)
    {
        String str;
        
        //System.out.println(table.length); 
        //Map<String,Integer> map=new HashMap<String,Integer>();
        Scanner scanner=new Scanner(System.in);

        System.out.println("input:");
        str=scanner.nextLine().toLowerCase();
        while(str!=null)
        {
            //System.out.println("output:"+str);
            int i=0;
            String[] table=new String[50];
            int[] value=new int[50];
            for(int j=0;j<str.length();++j)
            {
                //System.out.println(str.length());
                if(!Character.isLetter(str.charAt(j))) //not alpha
                {
                    //System.out.println(j);
                    if(i!=j)
                    {
                        System.out.println(str.substring(i,j));
                        //if(map.containsKey(str.substring(i,j)));
                           // map(str.substring(i,j),)
                        for(int k=0;k<table.length;++k)
                        {
                            if(table[k]==null)
                            {
                                table[k]=str.substring(i,j);
                                value[k]=1;
                                break;
                            }
                            if(table[k].equals(str.substring(i,j)))
                            {
                                ++value[k];
                                break;
                            }
                        }
                    }
                    i=j+1;
                }
            }
            if(i!=str.length())
            {
                System.out.println(str.substring(i,str.length()));
                for(int k=0;k<table.length;++k)
                {
                    if(table[k]==null)
                    {
                        table[k]=str.substring(i,str.length());
                        value[k]=1;
                        break;
                    }
                    if(table[k].equals(str.substring(i,str.length())))
                    {
                        ++value[k];
                        break;
                    }
                }
            }
            for(int k=0;k<table.length;++k)
            {
                if(table[k]!=null)
                {
                    System.out.print(table[k]+" : ");
                    System.out.println(value[k]);
                }
            }
            System.out.println("input:");
            str=scanner.nextLine().toLowerCase();
        }
    }
}