package at.edu.c02.ledcontroller;

import java.io.IOException;

public interface LedController {
    void demo() throws IOException;
    void demo2(int id, String color, boolean state) throws IOException;
}
