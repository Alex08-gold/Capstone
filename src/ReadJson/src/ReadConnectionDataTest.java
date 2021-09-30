package ReadJson.src;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ReadConnectionDataTest {

    ReadConnectionData readConnectionData;

    public ReadConnectionDataTest() throws FileNotFoundException {
        this.readConnectionData = new ReadConnectionData("/home/alex/RoboViz/GenerationBest-1.json");
    }

    @Test
    void createData() {
        String exspect = "Core"+"\t"+"Hip1";
        ConnectData cd = new ConnectData();
        readConnectionData.createData(readConnectionData.getJsonArray().get(0), cd);
        assertEquals(exspect, cd.toString());
    }
}