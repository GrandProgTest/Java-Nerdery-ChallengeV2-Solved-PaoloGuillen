package extraChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

public class FileJavaReaderJson {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Welcome to the Weather Stations terminal!");
        System.out.println("¿Do you want to see the every statistic?");

        while (true) {
            String userInput = scanner.next();

            if ("Exit".equalsIgnoreCase(userInput)) {
                break;
            }
            if ("Yes".equalsIgnoreCase(userInput)) {
                JsonFileReader();
            } else {
                System.out.println("Please enter a valid input");
            }
        }

    }

    public static void JsonFileReader() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File WeatherStationsJsonFile = new File("src\\main\\java\\extraChallenge\\WeatherStations.json");
        JSONFileBody jsonFileBody = objectMapper.readValue(WeatherStationsJsonFile, JSONFileBody.class);
        List<List<Object>> records = jsonFileBody.records;
        List<WeatherStationEntity> weatherStationEntities = new ArrayList<WeatherStationEntity>();

        for(List<Object> record : records)
        {
            WeatherStationEntity entity = new WeatherStationEntity(
                    (Integer) record.get(0),
                    record.get(1).toString(),
                    record.get(2).toString(),
                    record.get(3).toString(),
                    record.get(4).toString(),
                    record.get(5).toString(),
                    record.get(6).toString(),
                    record.get(7).toString(),
                    record.get(8).toString(),
                    record.get(9) != null ? Double.valueOf(record.get(9).toString()) : 0.0,
                    record.get(10) != null ? Double.valueOf(record.get(10).toString()) : 0.0,
                    record.get(11) != null ? Double.valueOf(record.get(11).toString()) : 0.0,
                    record.get(12) != null ? Double.valueOf(record.get(12).toString()) : 0.0,
                    record.get(13) != null ? Double.valueOf(record.get(13).toString()) : 0.0,
                    record.get(14) != null ? Double.valueOf(record.get(14).toString()) : 0.0,
                    record.get(15) != null ? Double.valueOf(record.get(15).toString()) : 0.0,
                    record.get(16) != null ? Double.valueOf(record.get(16).toString()) : 0.0,
                    record.get(17) != null ? Double.valueOf(record.get(17).toString()) : 0.0,
                    record.get(18) != null ? Double.valueOf(record.get(18).toString()) : 0.0,
                    record.get(19) != null ? Double.valueOf(record.get(19).toString()) : 0.0
            );
            weatherStationEntities.add(entity);
        }



        System.out.printf(
                "Average Air Temperature: %.2f\nMax Air Temperature: %.2f\nMin Air Temperature: %.2f\n" +
                        "Average Atmospheric Pressure: %.2f\nMax Atmospheric Pressure: %.2f\nMin Atmospheric Pressure: %.2f\n" +
                        "Average Gust Speed: %.2f\nMax Gust Speed: %.2f\nMin Gust Speed: %.2f\n" +
                        "Average Precipitation: %.2f\nMax Precipitation: %.2f\nMin Precipitation: %.2f\n" +
                        "Average Relative Humidity: %.2f\nMax Relative Humidity: %.2f\nMin Relative Humidity: %.2f\n" +
                        "Average Solar: %.2f\nMax Solar: %.2f\nMin Solar: %.2f\n" +
                        "Average Strike Distance: %.2f\nMax Strike Distance: %.2f\nMin Strike Distance: %.2f\n" +
                        "Average Strikes: %.2f\nMax Strikes: %.2f\nMin Strikes: %.2f\n" +
                        "Average Vapour Pressure: %.2f\nMax Vapour Pressure: %.2f\nMin Vapour Pressure: %.2f\n" +
                        "Average Wind Direction: %.2f\nMax Wind Direction: %.2f\nMin Wind Direction: %.2f\n" +
                        "Average Wind Speed: %.2f\nMax Wind Speed: %.2f\nMin Wind Speed: %.2f\n",
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getAirtemp, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getAirtemp, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getAirtemp, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getAtmosphericpressure, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getAtmosphericpressure, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getAtmosphericpressure, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getGustspeed, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getGustspeed, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getGustspeed, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getPrecipitation, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getPrecipitation, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getPrecipitation, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getRelativehumidity, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getRelativehumidity, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getRelativehumidity, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getSolar, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getSolar, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getSolar, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getStrikedistance, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getStrikedistance, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getStrikedistance, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getStrikes, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getStrikes, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getStrikes, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getVapourpressure, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getVapourpressure, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getVapourpressure, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getWinddirection, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getWinddirection, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getWinddirection, "min"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getWindspeed, "average"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getWindspeed, "max"),
                calculateStatistic(weatherStationEntities, WeatherStationEntity::getWindspeed, "min")
        );
    }


    public static Double calculateStatistic(List<WeatherStationEntity> weatherStationEntities, ToDoubleFunction<WeatherStationEntity> metricFunction, String operation) {
        switch (operation.toLowerCase()) {
            case "average":
                return weatherStationEntities.stream()
                        .mapToDouble(metricFunction)
                        .average()
                        .getAsDouble();
            case "min":
                return weatherStationEntities.stream()
                        .mapToDouble(metricFunction)
                        .min()
                        .getAsDouble();
            case "max":
                return weatherStationEntities.stream()
                        .mapToDouble(metricFunction)
                        .max()
                        .getAsDouble();
            default:
                throw new IllegalArgumentException("Case has not been met or metric function does not exist: " + operation);
        }
    }
}