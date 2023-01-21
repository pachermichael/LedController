package at.edu.c02.ledcontroller;

import org.json.JSONObject;

import java.io.IOException;

public interface ApiService {
    JSONObject getLights() throws IOException;
    void setLight(int id, String color, boolean state) throws IOException;
    JSONObject getLights(int id) throws IOException;
}
