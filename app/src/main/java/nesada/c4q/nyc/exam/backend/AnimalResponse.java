package nesada.c4q.nyc.exam.backend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnimalResponse {
    private static final String JSON_ANIMALS = "animals";
    private static final String JSON_SUCCESS = "success";
    private static final String JSON_NAME = "name";
    private static final String JSON_TEXTCOLOR = "textColor";
    private static final String JSON_BACKGROUND = "background";
    private boolean success;
    private List<Animal> animals;

    public List<Animal> getAnimals(){
        return animals;
    }

    public static AnimalResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            boolean successful = json.getBoolean(JSON_SUCCESS);
            JSONArray animalList = json.getJSONArray(JSON_ANIMALS);

            AnimalResponse result = new AnimalResponse();
            result.success = successful;
            result.animals = parseAnimalList(animalList);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return buildFailureCase();
    }

    private static List<Animal> parseAnimalList(JSONArray animalList) {
        List<Animal> result = new ArrayList<>();
        for (int index = 0; index < animalList.length(); index++){
            try {
                JSONObject current = animalList.getJSONObject(index);

                String name = current.getString(JSON_NAME);
                String textColor = current.getString(JSON_TEXTCOLOR);
                String background = current.getString(JSON_BACKGROUND);
                Animal newAnimal = new Animal(name, textColor,background);
                result.add(newAnimal);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static AnimalResponse buildFailureCase() {
        AnimalResponse result = new AnimalResponse();
        result.success = false;
        result.animals = new ArrayList<>();
        return result;
    }
}
