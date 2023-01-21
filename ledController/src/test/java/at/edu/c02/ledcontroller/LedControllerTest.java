package at.edu.c02.ledcontroller;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;


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
    public void test() throws IOException {
       ApiService service= mock(ApiService.class);
       when(service.getLights()).thenReturn(new JSONObject("{\"lights\":[{\"id\":57,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":58,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":59,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":60,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":61,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":11,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":12,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":13,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":14,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":15,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":16,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":20,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":21,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":22,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":23,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":24,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":25,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":26,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":27,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"C\"}}, {\"id\":28,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":29,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":30,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":31,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":32,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":33,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":34,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":35,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"D\"}}, {\"id\":36,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":37,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":38,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":39,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":40,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":41,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":42,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":43,\"color\":\"#fff\",\"on\":true,\"groupByGroup\":{\"name\":\"E\"}}, {\"id\":1,\"color\":\"#ffd000\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":5,\"color\":\"#ffd000\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":6,\"color\":\"#ffd000\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":7,\"color\":\"#ffd0ff\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":8,\"color\":\"#ffd0ff\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":9,\"color\":\"#ffd0ff\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":3,\"color\":\"#ffd0ff\",\"on\":true,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":4,\"color\":\"#fff\",\"on\":false,\"groupByGroup\":{\"name\":\"F\"}}, {\"id\":2,\"color\":\"#cde\",\"on\":true,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":10,\"color\":\"#0f0\",\"on\":false,\"groupByGroup\":{\"name\":\"B\"}}, {\"id\":46,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":47,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":48,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":49,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":50,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":51,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":52,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":53,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"G\"}}, {\"id\":54,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":55,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}, {\"id\":56,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"H\"}}]}"));
       LedController controller= new LedControllerImpl(service);
       controller.movingLights();
       verify(service).setLight(2,"#00FFFF",true);
        verify(service).setLight(2,"#00FFFF",false);

        verify(service).setLight(10,"#00FFFF",true);
        verify(service).setLight(10,"#00FFFF",false);

        verify(service).setLight(11,"#00FFFF",true);
        verify(service).setLight(11,"#00FFFF",false);

        verify(service).setLight(12,"#00FFFF",true);
        verify(service).setLight(12,"#00FFFF",false);

        verify(service).setLight(13,"#00FFFF",true);
        verify(service).setLight(13,"#00FFFF",false);

        verify(service).setLight(14,"#00FFFF",true);
        verify(service).setLight(14,"#00FFFF",false);

        verify(service).setLight(15,"#00FFFF",true);
        verify(service).setLight(15,"#00FFFF",false);

        verify(service).setLight(16,"#00FFFF",true);
        verify(service).setLight(16,"#00FFFF",false);


    }
}
