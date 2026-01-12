package extraChallenge;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

public class WeatherStationEntity {


    public int _id;
    public String dev_id;
    public String name;
    public String location;
    public String keep_record;
    public OffsetDateTime time;
    public String year;
    public String month;
    public String dayofweek;
    public Double airtemp;
    public Double atmosphericpressure;
    public Double gustspeed;
    public Double precipitation;
    public Double relativehumidity;
    public Double solar;
    public Double strikedistance;
    public Double strikes;
    public Double vapourpressure;
    public Double winddirection;
    public Double windspeed;

    public WeatherStationEntity(){

    }

    public WeatherStationEntity(int _id, String dev_id, String name, String location, String keep_record, OffsetDateTime  time, String year, String month, String dayofweek, Double airtemp, Double atmosphericpressure, Double gustspeed, Double precipitation, Double relativehumidity, Double solar, Double strikedistance, Double strikes, Double vapourpressure, Double winddirection, Double windspeed) {
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

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKeep_record() {
        return keep_record;
    }

    public void setKeep_record(String keep_record) {
        this.keep_record = keep_record;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public Double getAirtemp() {
        return airtemp;
    }

    public void setAirtemp(Double airtemp) {
        this.airtemp = airtemp;
    }

    public Double getAtmosphericpressure() {
        return atmosphericpressure;
    }

    public void setAtmosphericpressure(Double atmosphericpressure) {
        this.atmosphericpressure = atmosphericpressure;
    }

    public Double getGustspeed() {
        return gustspeed;
    }

    public void setGustspeed(Double gustspeed) {
        this.gustspeed = gustspeed;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getRelativehumidity() {
        return relativehumidity;
    }

    public void setRelativehumidity(Double relativehumidity) {
        this.relativehumidity = relativehumidity;
    }

    public Double getSolar() {
        return solar;
    }

    public void setSolar(Double solar) {
        this.solar = solar;
    }

    public Double getStrikedistance() {
        return strikedistance;
    }

    public void setStrikedistance(Double strikedistance) {
        this.strikedistance = strikedistance;
    }

    public Double getStrikes() {
        return strikes;
    }

    public void setStrikes(Double strikes) {
        this.strikes = strikes;
    }

    public Double getVapourpressure() {
        return vapourpressure;
    }

    public void setVapourpressure(Double vapourpressure) {
        this.vapourpressure = vapourpressure;
    }

    public Double getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(Double winddirection) {
        this.winddirection = winddirection;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    @Override
    public String toString() {
        return "WeatherStationEntity{" +
                "_id=" + _id +
                ", dev_id='" + dev_id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", keep_record='" + keep_record + '\'' +
                ", time='" + time + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", dayofweek='" + dayofweek + '\'' +
                ", airtemp=" + airtemp +
                ", atmosphericpressure=" + atmosphericpressure +
                ", gustspeed=" + gustspeed +
                ", precipitation=" + precipitation +
                ", relativehumidity=" + relativehumidity +
                ", solar=" + solar +
                ", strikedistance=" + strikedistance +
                ", strikes=" + strikes +
                ", vapourpressure=" + vapourpressure +
                ", winddirection=" + winddirection +
                ", windspeed=" + windspeed +
                '}';
    }
}