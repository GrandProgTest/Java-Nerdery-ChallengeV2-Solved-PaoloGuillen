import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileJavaReaderJson {

    public static void main(String[] args) throws IOException {
        JsonFileReader();
    }

    public static void JsonFileReader() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File WeatherStationsJsonFile = new File("src\\main\\java\\Stations.json");
        JSONFileBody jsonFileBody = objectMapper.readValue(WeatherStationsJsonFile, JSONFileBody.class);
        for(int i = 0; i<jsonFileBody.records.size(); i++)
        {
            System.out.println("Weather station print try: "+ jsonFileBody.records.size());
        }
    }
}