import com.kamnetanker.ToBeTested;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ToBeTested_parametrized {
    private int[] a,b,c;
    ToBeTested_parametrized(int[] a, int[]b,int[]c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{ 1,2,3 },new int[]{5, 1, 1},new int[]{5, 2, 3}},
                {new int[]{7, 6, 1},new int[]{3, 2 ,1},new int[]{7, 6, 1}},
                {new int[]{1, 2, 3},new int[]{1, 2, 3},new int[]{1, 2, 3}},
                {new int[]{1,2,3},new int[]{5, 1, 1},new int[]{5, 2, 3}},
                {new int[]{7, 6, 1},new int[]{3, 2 ,1},new int[]{7, 6, 1}}
        });
    }

    @Test
    public void testMethod1() throws Exception{
        Assert.assertArrayEquals(c, ToBeTested.method1(a,b));
    }


}
