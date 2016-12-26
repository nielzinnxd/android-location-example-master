package teamtreehouse.com.iamhere;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by dleite on 07/11/2016.
 */
public class CEPDEC implements JsonDeserializer{

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement element = json.getAsJsonObject();
        if(json.getAsJsonObject() != null){
            element = json.getAsJsonObject();
        }

        return (new Gson().fromJson(element,CEP.class));



    }
}
