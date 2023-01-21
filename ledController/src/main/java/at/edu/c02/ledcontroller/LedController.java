package at.edu.c02.ledcontroller;

import java.io.IOException;
import java.util.List;

public interface LedController {
    void demo() throws IOException;
    List<Boolean> getGroupLeds() throws IOException;
}
