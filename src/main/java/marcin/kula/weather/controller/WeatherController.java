package marcin.kula.weather.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import marcin.kula.weather.tools.Tools;
import marcin.kula.weather.weathermodel.WeatherModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String weather(Model model) {

        ForecastIO fio = new ForecastIO("7899112043832da3cb4247d96f5eebab");
        fio.setLang("pl");
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setExcludeURL("hourly,minutely");
        fio.getForecast("50.0647", "19.945");

        FIODaily daily = new FIODaily(fio);
        List<WeatherModel> weatherModels = new LinkedList<>();

        FIOCurrently currently = new FIOCurrently(fio);
        String [] f  = currently.get().getFieldsArray();

        for (int i = 1; i < daily.days(); i++) {

            String[] h = daily.getDay(i).getFieldsArray();
            WeatherModel weatherModel = new WeatherModel();

            weatherModel.setWindGust(daily.getDay(i).getByKey(h[0]));
            weatherModel.setMaxTemperature(daily.getDay(i).getByKey(h[2]));
            weatherModel.setMaxTemperatureTime(daily.getDay(i).getByKey(h[7]).substring(0, 5));
            weatherModel.setIcon(daily.getDay(i).getByKey(h[3]).substring(1, daily.getDay(i).getByKey(h[3]).length()-1));
            weatherModel.setMinTemperature(daily.getDay(i).getByKey(h[24]));
            weatherModel.setMinTemperatureTime(daily.getDay(i).getByKey(h[28]).substring(0, 5));
            weatherModel.setWindSpeed(daily.getDay(i).getByKey(h[14]));
            weatherModel.setSunriseTime(daily.getDay(i).getByKey(h[16]).substring(0, 5));
            weatherModel.setSunsetTime(daily.getDay(i).getByKey(h[9]).substring(0, 5));
            weatherModel.setSummary(daily.getDay(i).getByKey(h[18]).substring(1, daily.getDay(i).getByKey(h[18]).length()-1));
            weatherModel.setPressure(daily.getDay(i).getByKey(h[26]));
            weatherModel.setTime(daily.getDay(i).getByKey(h[34]));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime formatDateTime = LocalDateTime.parse(weatherModel.getTime(), formatter);

            if(formatDateTime.getDayOfWeek() == DayOfWeek.MONDAY)
                weatherModel.setDayOfWeekInPolish("Poniedziałek");
            else if(formatDateTime.getDayOfWeek() == DayOfWeek.TUESDAY)
                weatherModel.setDayOfWeekInPolish("Wtorek");
            else if(formatDateTime.getDayOfWeek() == DayOfWeek.WEDNESDAY)
                weatherModel.setDayOfWeekInPolish("Środa");
            else if(formatDateTime.getDayOfWeek() == DayOfWeek.THURSDAY)
                weatherModel.setDayOfWeekInPolish("Czwartek");
            else if(formatDateTime.getDayOfWeek() == DayOfWeek.FRIDAY)
                weatherModel.setDayOfWeekInPolish("Piątek");
            else if(formatDateTime.getDayOfWeek() == DayOfWeek.SATURDAY)
                weatherModel.setDayOfWeekInPolish("Sobota");
            else if(formatDateTime.getDayOfWeek() == DayOfWeek.SUNDAY)
                weatherModel.setDayOfWeekInPolish("Niedziela");

            weatherModel.setTime(daily.getDay(i).getByKey(h[34]).substring(0, 11));

            String pProbString = daily.getDay(i).getByKey(h[19]);
            double pProbDouble = Double.parseDouble(pProbString);

            weatherModel.setPrecipProbability(Tools.round(pProbDouble*100, 0));

            weatherModels.add(weatherModel);
        }

        model.addAttribute("currentTemperature", currently.get().getByKey(f[12]));
        model.addAttribute("weatherModels", weatherModels);

        return "weather";
    }
}
