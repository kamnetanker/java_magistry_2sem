import com.kamnetanker.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToBeTestedTest {
    private ToBeTested tbt;
    public void Method1Test(int[] a, int[] b, int[] c) throws Exception{
        Assert.assertArrayEquals(a, ToBeTested.method1(b,c));
    }
    @Before
    public void CreateInstances(){
        tbt = new ToBeTested();
    }
    @Test
    public void Method1Test() throws Exception {
        int[][] testArrays = new int[][]{
                new int[]{ 1,2,3 },new int[]{5, 1, 1},new int[]{5, 2, 3},
                new int[]{7, 6, 1},new int[]{3, 2 ,1},new int[]{7, 6, 1},
                new int[]{1, 2, 3},new int[]{1, 2, 3},new int[]{1, 2, 3},
                new int[]{1,2,3},new int[]{5, 1, 1},new int[]{5, 2, 3},
                new int[]{7, 6, 1},new int[]{3, 2 ,1},new int[]{7, 6, 1}
        };
        for(int i=0; i<testArrays.length; i+=3)
        {
            Method1Test(testArrays[i+2], testArrays[i],testArrays[i+1]);
        }
    }
    @Test
    public void TestIsContainsDigit() throws Exception {
        String[] testStrings = new String[]{
                "string 1",
                "test string",
                "123"};
        boolean[] testAnswers = new boolean[]{
                true,
                false,
                true
        };
        for(int i=0; i<testStrings.length; i++){
            Assert.assertEquals(testAnswers[i], tbt.isContainsDigit(testStrings[i]));
        }
    }

}
