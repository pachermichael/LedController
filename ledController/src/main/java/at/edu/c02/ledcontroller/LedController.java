package at.edu.c02.ledcontroller;

import java.io.IOException;
import java.util.List;

public interface LedController {
    void demo() throws IOException;
    List<Boolean> getGroupLeds() throws IOException;

    void getGroupStatus() throws IOException;
    void getLightStatus(int id) throws IOException;

    void turnOffAllLeds() throws IOException;
    List<Integer> groupIds() throws IOException;


}
