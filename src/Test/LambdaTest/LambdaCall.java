package Test.LambdaTest;

/**
 * Created by mcstarioni on 03.12.2016.
 */
public class LambdaCall {
    public static class LambdaAccepter {

    }
    public static LamdaInterface lambda;
    public static void main(String[] args) {
        lambda = ()-> System.out.println("Do lambda throught lambda");
        lambda.doLambda();
    }
}
