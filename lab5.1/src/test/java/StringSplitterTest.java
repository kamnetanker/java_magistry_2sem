import com.kamnetanker.StringSplitter;
import org.junit.Assert;
import org.junit.Test;

public class StringSplitterTest {
    public void testStringSplit(String toBeSplitted, String[] ResultArray){
        Assert.assertArrayEquals(ResultArray, StringSplitter.SplitString(toBeSplitted));
    }
    @Test
    public void testStringSplit(){
        String[] testData = new String[] {
                "1 2 3", "word war z", "not test data", "how", "to compile"

        };
        String[][] testAnswer = new String[][]{
                new String[]{
                        "1","2","3"
                },
                new String[]{
                        "word","war","z"
                },
                new String[]{
                        "not","test","data"
                },
                new String[]{
                    "how"
                },
                new String[]{
                        "to","compile"
                }
        };
        for(int i=0; i<testData.length; i++)
        testStringSplit(testData[i], testAnswer[i]);
    }
}
