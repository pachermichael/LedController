package at.edu.c02.ledcontroller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the actual logic
 */
public class LedControllerImpl implements LedController {
    private final ApiService apiService;

    public LedControllerImpl(ApiService apiService)
    {
        this.apiService = apiService;
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

    public List<JSONObject> groupIds() throws IOException {
        List<JSONObject> groupIdList = new ArrayList<>();

        JSONObject response = apiService.getLights();
        JSONArray lights = response.getJSONArray("lights");

        JSONObject groupObject;
        JSONObject groupByGroup;

        for (int i = 0; i < lights.length(); i++) {

            groupObject = lights.getJSONObject(i);
            groupByGroup = groupObject.getJSONObject("groupByGroup");

            if(groupByGroup.getString("name").equals("B")){
                groupIdList.add(groupObject);
            }
        }

        return groupIdList;
    }

    @Override
    public List<Boolean> getGroupLeds() throws IOException {
        List<Boolean> ledstatus = new ArrayList<>();

        for (int i = 0; i < groupIds().size(); i++) {

            ledstatus.add(groupIds().get(i).getBoolean("on"));

        }
        return ledstatus;
    }

    @Override
    public void turnOffAllLeds() throws IOException {

        for (int i = 0; i < groupIds().size(); i++) {
            if(getGroupLeds().get(i).equals(true)){
             // lights.getJSONObject(i).getBoolean("on");
            }
        }
    }
}
