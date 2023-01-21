package at.edu.c02.ledcontroller;

import org.json.JSONObject;

import java.io.IOException;

public class ApiServiceMock implements ApiService{
    @Override
    public JSONObject getLights() throws IOException {
        return new JSONObject(
                "{\"lights\":\n" +
                        "[\n" +
                        "{\"id\":1,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"test\"}},\n" +
                        "{\"id\":2,\"color\":\"#000\",\"on\":true,\"groupByGroup\":{\"name\":\"test\"}},\n" +
                        "{\"id\":3,\"color\":\"#000\",\"on\":false,\"groupByGroup\":{\"name\":\"test\"}},\n" +
                        "]}"
        );
    }

    @Override
    public void setLight(int id, String color, boolean state) throws IOException {
        //
    }

    @Override
    public JSONObject getLights(int id) throws IOException {
        return null;
    }
}
