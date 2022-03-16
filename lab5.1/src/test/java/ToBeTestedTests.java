import com.kamnetanker.*;
import org.junit.*;

public class ToBeTestedTests {
    private ToBeTested tbt;
    public void testMethod1(int[] a, int[] b, int[] c) throws Exception{
        Assert.assertArrayEquals(c, ToBeTested.method1(a,b));
    }
    @Before
    public void CreateInstances(){
        tbt = new ToBeTested();
    }
    @Test
    public void testMethod1() throws Exception {
        int[][] testArrays = new int[][]{
                new int[]{ 1,2,3 },new int[]{5, 1, 1},new int[]{5, 2, 3},
                new int[]{7, 6, 1},new int[]{3, 2 ,1},new int[]{7, 6, 1},
                new int[]{1, 2, 3},new int[]{1, 2, 3},new int[]{1, 2, 3},
                new int[]{1,2,3},new int[]{5, 1, 1},new int[]{5, 2, 3},
                new int[]{7, 6, 1},new int[]{3, 2 ,1},new int[]{7, 6, 1}
        };
        for(int i=0; i<testArrays.length; i+=3)
        {
            testMethod1(testArrays[i+2], testArrays[i],testArrays[i+1]);
        }
    }
    @Test
    public void testIsContainsDigit() throws Exception {
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
