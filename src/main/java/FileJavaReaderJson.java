import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileJavaReaderJson {

    public static void main(String[] args) throws IOException {
        JsonFileReader();
    }

    public static void JsonFileReader() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File WeatherStationsJsonFile = new File("src\\main\\java\\Stations.json");
        JSONFileBody jsonFileBody = objectMapper.readValue(WeatherStationsJsonFile, JSONFileBody.class);
        List<List<Object>> records = jsonFileBody.records;
        List<WeatherStationEntity> weatherStationEntities = new ArrayList<WeatherStationEntity>();

        for (int i = 0; i < records.size(); i++) {
            List<Object> record = records.get(i);
            WeatherStationEntity entity = new WeatherStationEntity(
                    (int) record.get(0),
                    (String) record.get(1),
                    (String) record.get(2),
                    (String) record.get(3),
                    (String) record.get(4),
                    (String) record.get(5),
                    (String) record.get(6),
                    (String) record.get(7),
                    (String) record.get(8),
                    (String) record.get(9),
                    (String) record.get(10),
                    (String) record.get(11),
                    (String) record.get(12),
                    (String) record.get(13),
                    (String) record.get(14),
                    (String) record.get(15),
                    (String) record.get(16),
                    (String) record.get(17),
                    (String) record.get(18),
                    (String) record.get(19)
            );
            weatherStationEntities.add(entity);
        }
        System.out.print("----------------------------------------------------------");

    }
}