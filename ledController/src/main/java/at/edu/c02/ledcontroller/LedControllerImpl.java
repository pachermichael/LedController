package at.edu.c02.ledcontroller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * This class handles the actual logic
 */
public class LedControllerImpl implements LedController {
    private final ApiService apiService;
    private final String groupName;

    public LedControllerImpl(ApiService apiService)
    {
        this.apiService = apiService;
        groupName = "B";
    }

    @Override
    public void demo() throws IOException
    {
        // Call `getLights`, the response is a json object in the form `{ "lights": [ { ... }, { ... } ] }`
        JSONObject response = apiService.getLights();
        // get the "lights" array from the response
        JSONArray lights = response.getJSONArray("lights");
        // read the first json object of the lights array
        JSONObject firstLight = lights.getJSONObject(0);
        // read int and string properties of the light
        System.out.println("First light id is: " + firstLight.getInt("id"));
        System.out.println("First light color is: " + firstLight.getString("color"));
    }

    @Override
    public List<Boolean> getGroupLeds() throws IOException {
        List<Boolean> ledstatus = new ArrayList<>();

        List<JSONObject> lights = filterLights(apiService.getLights());
        lights.forEach(n ->ledstatus.add(n.getBoolean("on")));

        return ledstatus;
    }

    @Override
    public void getGroupStatus() throws IOException {
        showState(filterLights(apiService.getLights()));
    }

    @Override
    public void getLightStatus(int id) throws IOException {
        List<JSONObject> lights = filterLights(apiService.getLights());
        ArrayList<JSONObject> list = new ArrayList();

        for (Object test: lights) {
            JSONObject light = (JSONObject) test;
            if(light.getInt("id") == id){
                list.add(light);
                break;
            }
        }
        showState(list);
    }

    private void showState(Collection<JSONObject> lights){
        lights.forEach(n -> {
            JSONObject light = (JSONObject)n;
            String state = light.getBoolean("on")?"on":"off";
            String out = String.format("LED %d is currently %s. Color: %s",light.getInt("id"),state,light.getString("color"));
            System.out.println(out);
        });
    }

    private List<JSONObject> filterLights(JSONObject response){
        JSONArray lights = response.getJSONArray("lights");
        List<JSONObject> filteredLights = new ArrayList<>();

        lights.forEach(n ->{
            JSONObject light = (JSONObject) n;
            if(light.getJSONObject("groupByGroup").get("name").equals(groupName)){
                filteredLights.add(light);
            }
        });
        return filteredLights;
    }
}
