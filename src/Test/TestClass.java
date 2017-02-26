package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class TestClass {
    public static class Shit
    {
        int x;
        public void do_shit() throws Exception {
            do_more_shit();
        }
        public int do_more_shit() throws Exception {
            throw new Exception();
        }
    }
    public static <T extends  Object > void doFuck(T element)
    {
        if(element.getClass().getName() == Shit.class.getName())
        {
            Shit shit = (Shit)element;
            System.out.println("We are in shit " + shit.x);
        }else
        {
            System.out.println("May be its not that bad :)");
        }
    }
    static String str;
    public static void main(String[] args) {
        /*
        Socket socket;
        try
        {
            socket = new Socket(InetAddress.getLocalHost(),8080);
            BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = dis.readLine();
            System.out.println(msg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        */
        Shit shit = new Shit();
        doFuck(shit);
    }
    private  class MaxLoxException extends Exception{}
}
