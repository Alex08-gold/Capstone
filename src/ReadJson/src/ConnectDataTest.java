package ReadJson.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectDataTest {

    ConnectData testData = new ConnectData("CoreComponent", "Hip1");

    @Test
    void getSrc() {
        assertEquals("CoreComponent", testData.getSrc());
    }

    @Test
    void getDest() {
        assertEquals("Hip1", testData.getDest());
    }

    @Test
    void testToString() {
        String exspect = "CoreComponent"+"\t"+"Hip1";
        assertEquals(exspect, testData.toString());
    }

    @Test
    void setSrc() {
        testData.setSrc("LowerLeg2");
        assertEquals("LowerLeg2", testData.getSrc());
    }

    @Test
    void setDest() {
        testData.setDest("UpperLeg1");
        assertEquals("UpperLeg1", testData.getDest());
    }
}