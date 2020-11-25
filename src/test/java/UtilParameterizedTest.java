import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(value=Parameterized.class)
public class UtilParameterizedTest {

    private int para1;
    private boolean soll;

    public UtilParameterizedTest(int para1, boolean soll){
        this.para1 = para1;
        this.soll = soll;
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {1,true},
                {6,true},
                {7,false},
                {12,false}
        });
    }

    @Test
    public void testIstErstesHalbjahr() {
        assertEquals(soll,Util.istErstesHalbjahr(para1));
    }
}
