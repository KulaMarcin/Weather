package marcin.kula.weather.weathermodel;

public class WeatherModel {

    private String windGust;
    private String maxTemperature;
    private String maxTemperatureTime;
    private String icon;
    private String minTemperature;
    private String minTemperatureTime;
    private String windSpeed;
    private String sunriseTime;
    private String sunsetTime;
    private String summary;
    private double precipProbability;
    private String pressure;
    private String time;
    private String dayOfWeekInPolish;
    private String currentTemperature;

    public WeatherModel() {
    }

    public WeatherModel(String windGust, String maxTemperature, String maxTemperatureTime, String icon, String minTemperature, String minTemperatureTime, String windSpeed, String sunriseTime, String sunsetTime, String summary, double precipProbability, String pressure, String time, String dayOfWeekInPolish, String currentTemperature) {
        this.windGust = windGust;
        this.maxTemperature = maxTemperature;
        this.maxTemperatureTime = maxTemperatureTime;
        this.icon = icon;
        this.minTemperature = minTemperature;
        this.minTemperatureTime = minTemperatureTime;
        this.windSpeed = windSpeed;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.summary = summary;
        this.precipProbability = precipProbability;
        this.pressure = pressure;
        this.time = time;
        this.dayOfWeekInPolish = dayOfWeekInPolish;
        this.currentTemperature = currentTemperature;
    }

    public String getDayOfWeekInPolish() {
        return dayOfWeekInPolish;
    }

    public void setDayOfWeekInPolish(String dayOfWeekInPolish) {
        this.dayOfWeekInPolish = dayOfWeekInPolish;
    }

    public String getWindGust() {
        return windGust;
    }

    public void setWindGust(String windGust) {
        this.windGust = windGust;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMaxTemperatureTime() {
        return maxTemperatureTime;
    }

    public void setMaxTemperatureTime(String maxTemperatureTime) {
        this.maxTemperatureTime = maxTemperatureTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMinTemperatureTime() {
        return minTemperatureTime;
    }

    public void setMinTemperatureTime(String minTemperatureTime) {
        this.minTemperatureTime = minTemperatureTime;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "windGust='" + windGust + '\'' +
                ", maxTemperature='" + maxTemperature + '\'' +
                ", maxTemperatureTime='" + maxTemperatureTime + '\'' +
                ", icon='" + icon + '\'' +
                ", minTemperature='" + minTemperature + '\'' +
                ", minTemperatureTime='" + minTemperatureTime + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", sunriseTime='" + sunriseTime + '\'' +
                ", sunsetTime='" + sunsetTime + '\'' +
                ", summary='" + summary + '\'' +
                ", precipProbability=" + precipProbability +
                ", pressure='" + pressure + '\'' +
                ", time='" + time + '\'' +
                ", dayOfWeekInPolish='" + dayOfWeekInPolish + '\'' +
                ", currentTemperature='" + currentTemperature + '\'' +
                '}';
    }
}
