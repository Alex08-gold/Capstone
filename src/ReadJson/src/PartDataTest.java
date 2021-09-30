package ReadJson.src;

import org.junit.jupiter.api.Test;
import static junit.framework.Assert.*;

class PartDataTest {

    PartData testData = new PartData("LowerLeg2", "FixedBrick",false,0);

   @Test
    void getID() {
       assertEquals("LowerLeg2", testData.getID());
    }

    @Test
    void getType() {
        assertEquals("FixedBrick", testData.getType());
    }

    @Test
    void setId() {
        testData.setId("Core");
        assertEquals("Core", testData.getID());
    }

    @Test
    void setType() {
       testData.setType("CoreComponent");
       assertEquals("CoreComponent", testData.getType());
    }

    @Test
    void isRoot() {
        assertFalse(testData.isRoot());
    }

    @Test
    void setRoot() {
        testData.setRoot(true);
        assertTrue(testData.isRoot());
    }

    @Test
    void getOrientation() {
        assertEquals(0, testData.getOrientation());
    }

    @Test
    void setOrientation() {
        testData.setOrientation(1);
        assertEquals(1, testData.getOrientation());
    }
    @Test void TestToString(){
       String exspected  = "LowerLeg2"+"\t"+"FixedBrick"+"\t"+"false"+"\t"+"0";
       assertEquals(exspected, testData.toString());
    }
}