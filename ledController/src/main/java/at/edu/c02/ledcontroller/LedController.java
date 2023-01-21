package at.edu.c02.ledcontroller;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public interface LedController {
    void demo() throws IOException;
    void demo2(int id, String color, boolean state) throws IOException;
    List<Boolean> getGroupLeds() throws IOException;
    void getGroupStatus() throws IOException;
    JSONObject getLightStatus(int id) throws IOException;
    void turnOffAllLeds() throws IOException;
    List<JSONObject> groupIds() throws IOException;
    void movingLights() throws IOException;
}
