package Test;

/**
 * Created by mcstarioni on 10.11.2016.
 */
public class LisaProgram
{
    public static void main(String[] args)
    {
        String s = "1/2 ";
        for(int i = 0; i < 5; i++)
        {
            s+="+((4*((-1)^("+i+"+1))-2)*sin(pi*"+i+"*x))/(pi*"+i+")";
            //s+="-("+i+"*pi + 2*"+i+"*pi*cos("+i+"*pi)-3*sin("+i+"*pi))*(sin(pi*"+i+"*x))/(("+i+"^2)*(pi^2))";
        }
        System.out.println(s);
    }

}

