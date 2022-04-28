package com.kamnetanker;




import java.util.List;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
@FunctionalInterface
interface MyExecutable{
    boolean execute(int arg);
}
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LambdaDemo(2,x->x%2==0);
        LambdaDemo(7,x->x%2==0);
        LambdaDemo(1,x->x%2==0);

        LambdaDemo(1,x->{
            boolean isPrime=true;
            // проверяем число на простоту
            for (int i=2; i<=x/2; i++) {
                x = x % i;
                if (x == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        });
        LambdaDemo(53,x->{
            boolean isPrime=true;
            // проверяем число на простоту
            for (int i=2; i<=x/2; i++) {
                x = x % i;
                if (x == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        });

        LambdaToMethod ltm = new LambdaToMethod();
        ltm.lambdaMethod(new Integer[]{7,4,6,1}, (x)->{
            Integer lowest = x[0];
            for(Integer i : x){
                lowest = (i<lowest)?i:lowest;
            }
            return lowest;
        });
    }
    private static void LambdaDemo(int arg, MyExecutable mx){
        System.out.println(mx.execute(arg));
    }
}
class LambdaToMethod{
    public static Integer Sum(Integer[] arg){
        Integer sum=0;
        for(Integer i : arg){
            sum+=i;
        }
        return sum;
    }
    public Integer Mean(Integer[] arg){
        Integer sum=0;
        for(Integer i : arg){
            sum+=i;
        }
        return sum/arg.length;
    }
    public void lambdaMethod(Integer[] arg, Function<Integer[], Integer> lambda){
        System.out.println();
        for(Integer i : arg){
            System.out.print(i.toString()+" ");
        }
        System.out.println();
        System.out.println(this.Mean(arg).toString()+"\n"+  LambdaToMethod.Sum(arg).toString()+"\n"+ lambda.apply(arg).toString());
    }
}
