package extraChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class ExtraChallenge {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Welcome to the Weather Stations terminal!");

        while (true) {
            System.out.println("Do you want to see every statistic? (YES / EXIT)");
            String userInput = scanner.next();

            if ("EXIT".equalsIgnoreCase(userInput)) {
                System.out.println("Goodbye, see you soon!");
                break;
            }

            if ("YES".equalsIgnoreCase(userInput)) {
                System.out.println("Consider info per day or general (DAY / GENERAL / EXIT)");
                userInput = scanner.next();

                if ("EXIT".equalsIgnoreCase(userInput)) {
                    System.out.println("Goodbye!");
                    break;
                }

                if ("DAY".equalsIgnoreCase(userInput)) {
                    JsonFileReader("DAY");
                } else if ("GENERAL".equalsIgnoreCase(userInput)) {
                    JsonFileReader(null);
                } else {
                    System.out.println("Invalid option. Please type DAY, GENERAL, or EXIT.");
                }

            } else {
                System.out.println("Invalid input. Please type YES or EXIT.");
            }
        }

        scanner.close();
    }


    public static void JsonFileReader(String considerDay) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File WeatherStationsJsonFile = new File("src\\main\\java\\extraChallenge\\WeatherStations.json");
        JSONFileBody jsonFileBody = objectMapper.readValue(WeatherStationsJsonFile, JSONFileBody.class);
        List<List<Object>> records = jsonFileBody.records;
        List<WeatherStationEntity> weatherStationEntities = new ArrayList<>();

        for (List<Object> record : records) {
            WeatherStationEntity entity = new WeatherStationEntity(
                    (Integer) record.get(0),
                    record.get(1).toString(),
                    record.get(2).toString(),
                    record.get(3).toString(),
                    record.get(4).toString(),
                    OffsetDateTime.parse(record.get(5).toString()),
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

        if ("DAY".equalsIgnoreCase(considerDay)) {
            Map<String, List<WeatherStationEntity>> groupedByDay = weatherStationEntities.stream()
                    .collect(Collectors.groupingBy(e -> e.getTime().toLocalDate().toString()));

            groupedByDay.forEach((day, entities) -> {
                String dayOfWeek = entities.get(0).getTime().getDayOfWeek().toString();
                System.out.printf("%s %s:\n", dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1).toLowerCase(), day);
                System.out.printf(
                        "\u2022 Average Air Temperature: %.2f\n\u2022 Max Air Temperature: %.2f\n\u2022 Min Air Temperature: %.2f\n" +
                                "\u2022 Average Atmospheric Pressure: %.2f\n\u2022 Max Atmospheric Pressure: %.2f\n\u2022 Min Atmospheric Pressure: %.2f\n" +
                                "\u2022 Average Gust Speed: %.2f\n\u2022 Max Gust Speed: %.2f\n\u2022 Min Gust Speed: %.2f\n" +
                                "\u2022 Average Precipitation: %.2f\n\u2022 Max Precipitation: %.2f\n\u2022 Min Precipitation: %.2f\n" +
                                "\u2022 Average Relative Humidity: %.2f\n\u2022 Max Relative Humidity: %.2f\n\u2022 Min Relative Humidity: %.2f\n" +
                                "\u2022 Average Solar: %.2f\n\u2022 Max Solar: %.2f\n\u2022 Min Solar: %.2f\n" +
                                "\u2022 Average Strike Distance: %.2f\n\u2022 Max Strike Distance: %.2f\n\u2022 Min Strike Distance: %.2f\n" +
                                "\u2022 Average Strikes: %.2f\n\u2022 Max Strikes: %.2f\n\u2022 Min Strikes: %.2f\n" +
                                "\u2022 Average Vapour Pressure: %.2f\n\u2022 Max Vapour Pressure: %.2f\n\u2022 Min Vapour Pressure: %.2f\n" +
                                "\u2022 Average Wind Direction: %.2f\n\u2022 Max Wind Direction: %.2f\n\u2022 Min Wind Direction: %.2f\n" +
                                "\u2022 Average Wind Speed: %.2f\n\u2022 Max Wind Speed: %.2f\n\u2022 Min Wind Speed: %.2f\n",
                        calculateStatistic(entities, WeatherStationEntity::getAirtemp, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getAirtemp, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getAirtemp, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getAtmosphericpressure, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getAtmosphericpressure, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getAtmosphericpressure, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getGustspeed, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getGustspeed, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getGustspeed, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getPrecipitation, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getPrecipitation, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getPrecipitation, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getRelativehumidity, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getRelativehumidity, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getRelativehumidity, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getSolar, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getSolar, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getSolar, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getStrikedistance, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getStrikedistance, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getStrikedistance, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getStrikes, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getStrikes, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getStrikes, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getVapourpressure, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getVapourpressure, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getVapourpressure, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getWinddirection, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getWinddirection, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getWinddirection, "min"),
                        calculateStatistic(entities, WeatherStationEntity::getWindspeed, "average"),
                        calculateStatistic(entities, WeatherStationEntity::getWindspeed, "max"),
                        calculateStatistic(entities, WeatherStationEntity::getWindspeed, "min")
                );
            });
        } else {
            System.out.printf(
                    "\u2022 Average Air Temperature: %.2f\n\u2022 Max Air Temperature: %.2f\n\u2022 Min Air Temperature: %.2f\n" +
                            "\u2022 Average Atmospheric Pressure: %.2f\n\u2022 Max Atmospheric Pressure: %.2f\n\u2022 Min Atmospheric Pressure: %.2f\n" +
                            "\u2022 Average Gust Speed: %.2f\n\u2022 Max Gust Speed: %.2f\n\u2022 Min Gust Speed: %.2f\n" +
                            "\u2022 Average Precipitation: %.2f\n\u2022 Max Precipitation: %.2f\n\u2022 Min Precipitation: %.2f\n" +
                            "\u2022 Average Relative Humidity: %.2f\n\u2022 Max Relative Humidity: %.2f\n\u2022 Min Relative Humidity: %.2f\n" +
                            "\u2022 Average Solar: %.2f\n\u2022 Max Solar: %.2f\n\u2022 Min Solar: %.2f\n" +
                            "\u2022 Average Strike Distance: %.2f\n\u2022 Max Strike Distance: %.2f\n\u2022 Min Strike Distance: %.2f\n" +
                            "\u2022 Average Strikes: %.2f\n\u2022 Max Strikes: %.2f\n\u2022 Min Strikes: %.2f\n" +
                            "\u2022 Average Vapour Pressure: %.2f\n\u2022 Max Vapour Pressure: %.2f\n\u2022 Min Vapour Pressure: %.2f\n" +
                            "\u2022 Average Wind Direction: %.2f\n\u2022 Max Wind Direction: %.2f\n\u2022 Min Wind Direction: %.2f\n" +
                            "\u2022 Average Wind Speed: %.2f\n\u2022 Max Wind Speed: %.2f\n\u2022 Min Wind Speed: %.2f\n",
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
    }

    public static Double calculateStatistic(List<WeatherStationEntity> weatherStationEntities, ToDoubleFunction<WeatherStationEntity> metricFunction, String operation) {
        switch (operation.toLowerCase()) {
            case "average":
                return weatherStationEntities.stream()
                        .mapToDouble(metricFunction)
                        .average()
                        .orElse(0.0);
            case "min":
                return weatherStationEntities.stream()
                        .mapToDouble(metricFunction)
                        .min()
                        .orElse(0.0);
            case "max":
                return weatherStationEntities.stream()
                        .mapToDouble(metricFunction)
                        .max()
                        .orElse(0.0);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}