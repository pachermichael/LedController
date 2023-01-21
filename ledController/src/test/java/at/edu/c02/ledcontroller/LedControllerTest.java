package at.edu.c02.ledcontroller;

import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;


public class LedControllerTest {

    /**
     * This test is just here to check if tests get executed. Feel free to delete it when adding your own tests.
     * Take a look at the stack calculator tests again if you are unsure where to start.
     */
    @Test
    public void dummyTest() {
        assertEquals(1, 1);
    }

    @Test
    public void turnOfAllLeds() throws IOException{

        //Funktioniert durch Mockito nicht (Abgesprochen mit Hr. Mattis Turin-Zelenko)

    }
    @Test
    public void getGroupLeds() throws IOException {

        ApiService apiService = new ApiServiceMock();
        LedControllerImpl ledController = new LedControllerImpl(apiService);

        assertEquals(ledController.getGroupLeds().get(0), false);
        assertEquals(ledController.getGroupLeds().get(1), true);
        assertEquals(ledController.getGroupLeds().get(2), false);


    }

}
