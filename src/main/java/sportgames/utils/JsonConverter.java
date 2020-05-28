package sportgames.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonConverter {
    private static final Logger LOGGER = Logger.getLogger(JsonConverter.class);

    public static String javaToJsonStr(Object object) {
        String jsonStr = "";

        try {
            LOGGER.info("Conversion to string.");
            ObjectMapper mapper = new ObjectMapper();
            jsonStr = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error in JavaToJsonStr:", e);
        }
        return jsonStr;
    }

    public static void javaToJsonFile(Object object, String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(path).toFile(), object);
            LOGGER.info("Writing to file.");

        } catch (JsonGenerationException e) {
            LOGGER.error("Error in JavaToJsonFile:", e);
        } catch (JsonMappingException e) {
            LOGGER.error("Error in JavaToJsonFile:", e);
        } catch (IOException e) {
            LOGGER.error("Error in JavaToJsonFile:", e);
        }
    }

    public static Object jsonStrToPOJO(String jsonStr) {
        Object object = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            object = mapper.readValue(jsonStr, Object.class);
            LOGGER.info("Conversion to POJO.");
        } catch (JsonMappingException e) {
            LOGGER.error("Error in jsonToPOJO:", e);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error in jsonToPOJO:", e);
        }
        return object;
    }

    public static Object jsonFileToPOJO(File file) {
        Object object = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            object = mapper.readValue(file, Object.class);

        } catch (JsonParseException e) {
            LOGGER.error("Error in jsonFileToPOJO:", e);
        } catch (JsonMappingException e) {
            LOGGER.error("Error in jsonFileToPOJO:", e);
        } catch (IOException e) {
            LOGGER.error("Error in jsonFileToPOJO:", e);
        }
        return object;
    }

}
