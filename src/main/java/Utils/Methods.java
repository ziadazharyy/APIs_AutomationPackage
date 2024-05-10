package Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Methods {

    public String getDateTime() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define a custom date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date and time using the defined format
        String formattedDateTime = now.format(formatter);

        // Print the formatted date and time
        return formattedDateTime;
    }

    public String getDate() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define a custom date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date and time using the defined format
        String formattedDateTime = now.format(formatter);

        // Print the formatted date and time
        return formattedDateTime;
    }

    public int random(){
        Random random = new Random();
        // Generating a random number between 0 and 9
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    public static String removeTagsFromJson(String jsonStr, List<String> tagsToRemove) {
        // Parse the original JSON string into a JSONObject
        JSONObject jsonObject = new JSONObject(jsonStr);

        // Remove the specified tags from the "data" object
        if (jsonObject.has("data")) {
            JSONObject dataObject = jsonObject.getJSONObject("data");
            for (String tag : tagsToRemove) {
                dataObject.remove(tag);
            }
        }

        // Convert the modified JSONObject back to a string
        return jsonObject.toString();
    }
    public static String removeJsonElements(JSONObject obj, String keyneedtoberemoved) {
        Iterator<?> keys;
        String key;
        keys = obj.keys();
        while (keys.hasNext()) {
            key = (String) keys.next();
            if(key.equals(keyneedtoberemoved)) {
                obj.remove(key);
                keys = obj.keys();

            }
            else if(obj.get(key) instanceof JSONObject) {
                JSONObject subObject = (JSONObject) obj.get(key);
                removeJsonElements(subObject,keyneedtoberemoved);
            }
            else if(obj.get(key) instanceof JSONArray) {
                JSONArray jArray = (JSONArray) obj.get(key);
                for(int i = 0; i < jArray.length(); i++) {
                    if(jArray.get(i) instanceof JSONObject) {
                        removeJsonElements((JSONObject)jArray.get(i),keyneedtoberemoved);
                    }
                }
            }
        }
        return obj.toString();
    }
    public static String removeMultipleJsonElements(JSONObject obj, String[] keyneedtoberemoved) {


        for (int x = 0; x < keyneedtoberemoved.length; x++) {
            Iterator<?> keys;
            String key;
            keys = obj.keys();
            while (keys.hasNext()) {
                key = (String) keys.next();
                if (key.equals(keyneedtoberemoved[x])) {
                    obj.remove(key);
                    keys = obj.keys();

                } else if (obj.get(key) instanceof JSONObject) {
                    JSONObject subObject = (JSONObject) obj.get(key);
                    removeJsonElements(subObject, keyneedtoberemoved[x]);
                } else if (obj.get(key) instanceof JSONArray) {
                    JSONArray jArray = (JSONArray) obj.get(key);
                    for (int i = 0; i < jArray.length(); i++) {
                        if (jArray.get(i) instanceof JSONObject) {
                            removeJsonElements((JSONObject) jArray.get(i), keyneedtoberemoved[x]);
                        }
                    }
                }
            }
        }

        return obj.toString();
    }
}
