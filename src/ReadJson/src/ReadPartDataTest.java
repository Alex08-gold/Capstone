package ReadJson.src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;

class ReadPartDataTest {

    ReadPartData readpartData;

    ReadPartDataTest() throws FileNotFoundException {
        readpartData = new ReadPartData("/home/alex/RoboViz/GenerationBest-1.json");
    }

    @Test
    void createData() {
        String exspect = "Core"+"\t"+"CoreComponent"+"\t"+true+"\t"+0;
        PartData pd = new PartData();
        readpartData.createData(readpartData.getJsonArray().get(0), pd);
        assertEquals(exspect, pd.toString());
    }

    @Test
    // This is basically testing createData method. Not sure whether or not to include this test. 
    void getDataArrayList() {
    }
}