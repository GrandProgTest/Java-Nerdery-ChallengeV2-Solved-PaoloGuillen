package extraChallenge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtraChallenge {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather Stations terminal!");

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
            WeatherStationEntity entity = WeatherStationEntity.mapToEntity(record);
            weatherStationEntities.add(entity);
        }

        if ("DAY".equalsIgnoreCase(considerDay)) {
            Map<String, List<WeatherStationEntity>> groupedByDay = weatherStationEntities.stream()
                    .collect(Collectors.groupingBy(e -> e.getTime().toLocalDate().toString()));

            groupedByDay.forEach((day, entities) -> {
                String dayOfWeek = entities.get(0).getTime().getDayOfWeek().toString();
                System.out.printf("%s %s:\n", dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1).toLowerCase(), day);
                printWeatherStatistics(entities);
            });
        } else {
            printWeatherStatistics(weatherStationEntities);
        }
    }

    private static void printWeatherStatistics(List<WeatherStationEntity> entities) {
        Object[] airtemp = printStatistics(entities, WeatherStationEntity::getAirtemp);
        Object[] atmosphericpressure = printStatistics(entities, WeatherStationEntity::getAtmosphericpressure);
        Object[] gustspeed = printStatistics(entities, WeatherStationEntity::getGustspeed);
        Object[] precipitation = printStatistics(entities, WeatherStationEntity::getPrecipitation);
        Object[] relativehumidity = printStatistics(entities, WeatherStationEntity::getRelativehumidity);
        Object[] solar = printStatistics(entities, WeatherStationEntity::getSolar);
        Object[] strikedistance = printStatistics(entities, WeatherStationEntity::getStrikedistance);
        Object[] strikes = printStatistics(entities, WeatherStationEntity::getStrikes);
        Object[] vapourpressure = printStatistics(entities, WeatherStationEntity::getVapourpressure);
        Object[] winddirection = printStatistics(entities, WeatherStationEntity::getWinddirection);
        Object[] windspeed = printStatistics(entities, WeatherStationEntity::getWindspeed);

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
                airtemp[0], airtemp[1], airtemp[2],
                atmosphericpressure[0], atmosphericpressure[1], atmosphericpressure[2],
                gustspeed[0], gustspeed[1], gustspeed[2],
                precipitation[0], precipitation[1], precipitation[2],
                relativehumidity[0], relativehumidity[1], relativehumidity[2],
                solar[0], solar[1], solar[2],
                strikedistance[0], strikedistance[1], strikedistance[2],
                strikes[0], strikes[1], strikes[2],
                vapourpressure[0], vapourpressure[1], vapourpressure[2],
                winddirection[0], winddirection[1], winddirection[2],
                windspeed[0], windspeed[1], windspeed[2]
        );
    }

    private static Object[] printStatistics(List<WeatherStationEntity> entities, ToDoubleFunction<WeatherStationEntity> metricFunction) {
        return new Object[]{
                calculateStatistic(entities, metricFunction, "average"),
                calculateStatistic(entities, metricFunction, "max"),
                calculateStatistic(entities, metricFunction, "min")
        };
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