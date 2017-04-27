package Test.Extention;

/**
 * Created by mcstarioni on 27.04.2017.
 */
public class A
{
    int a = 0;
    protected int b = 1;
    private int c = 2;
}
class B extends A
{
    B()
    {
        this.a++;
        this.b++;
    }
}
class C extends B
{
    C()
    {
        super();
        this.a++;
        this.b++;
    }
    public static void main(String[] args)
    {
        A a = new A();
        B b = new B();
        C c = new C();
        System.out.println("A: "+a.a+" "+a.b);
        System.out.println("B: "+b.a+" "+b.b);
        System.out.println("C: "+c.a+" "+c.b);
    }
}
