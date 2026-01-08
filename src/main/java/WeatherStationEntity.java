public class WeatherStationEntity {
    public int _id;
    public String dev_id;
    public String name;
    public String location;
    public String keep_record;
    public String time;
    public String year;
    public String month;
    public String dayofweek;
    public String airtemp;
    public String atmosphericpressure;
    public String gustspeed;
    public String precipitation;
    public String relativehumidity;
    public String solar;
    public String strikedistance;
    public String strikes;
    public String vapourpressure;
    public String winddirection;
    public String windspeed;

    public WeatherStationEntity(){

    }

    public WeatherStationEntity(int _id, String dev_id, String name, String location, String keep_record, String time, String year, String month, String dayofweek, String airtemp, String atmosphericpressure, String gustspeed, String precipitation, String relativehumidity, String solar, String strikedistance, String strikes, String vapourpressure, String winddirection, String windspeed) {
        this._id = _id;
        this.dev_id = dev_id;
        this.name = name;
        this.location = location;
        this.keep_record = keep_record;
        this.time = time;
        this.year = year;
        this.month = month;
        this.dayofweek = dayofweek;
        this.airtemp = airtemp;
        this.atmosphericpressure = atmosphericpressure;
        this.gustspeed = gustspeed;
        this.precipitation = precipitation;
        this.relativehumidity = relativehumidity;
        this.solar = solar;
        this.strikedistance = strikedistance;
        this.strikes = strikes;
        this.vapourpressure = vapourpressure;
        this.winddirection = winddirection;
        this.windspeed = windspeed;
    }

    public int get_id() {
        return _id;
    }

    public String getDev_id() {
        return dev_id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getKeep_record() {
        return keep_record;
    }

    public String getTime() {
        return time;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public String getAirtemp() {
        return airtemp;
    }

    public String getAtmosphericpressure() {
        return atmosphericpressure;
    }

    public String getGustspeed() {
        return gustspeed;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getRelativehumidity() {
        return relativehumidity;
    }

    public String getSolar() {
        return solar;
    }

    public String getStrikedistance() {
        return strikedistance;
    }

    public String getStrikes() {
        return strikes;
    }

    public String getVapourpressure() {
        return vapourpressure;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public String getWindspeed() {
        return windspeed;
    }
}