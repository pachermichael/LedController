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


        System.out.println(getGroupLeds().toString());
        turnOffAllLeds();
        System.out.println(getGroupLeds().toString());


        System.out.println(groupIds().toString());
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
    public void demo2(int id, String color, boolean state) throws IOException
    {
        JSONObject responseSetLight = apiService.setLight(id,color,state);
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

        for (JSONObject jo:groupIds()) {
            ledstatus.add(jo.getBoolean("on"));
        }

        return ledstatus;
    }

    @Override
    public void getGroupStatus() throws IOException {
        showState(filterLights(apiService.getLights()));
    }

    @Override
    public JSONObject getLightStatus(int id) throws IOException {
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
        return list.get(0);
    }

    private void showState(Collection<JSONObject> lights){
        lights.forEach(n -> {
            String state = n.getBoolean("on")?"on":"off";
            String out = String.format("LED %d is currently %s. Color: %s",n.getInt("id"),state,n.getString("color"));
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

    public void turnOffAllLeds() throws IOException {

        for (JSONObject jo:groupIds()) {
            if(jo.getBoolean("on")){
                apiService.setLight(jo.getInt("id"), "#000",false);
            }
        }

    }
}
