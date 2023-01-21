package at.edu.c02.ledcontroller;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class End2EndTest {

    @Test
    public void testSetLeds() throws Exception {

        ApiService apiService = new ApiServiceImpl();
        LedControllerImpl ledcontroller = new LedControllerImpl(apiService);
        ledcontroller.demo2(12, "#FF0000", true);
        assertEquals("{\"color\":\" #FF0000 \",\"id\":12,\"groupByGroup\":{\"name\":\"B\"},\"on\":true}" , ledcontroller.getLightStatus(12).toString());
    }
}
