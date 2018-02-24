package pl.narodzinyprogramisty;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class WeatherReader {

    private static final int MAX_TEMP = 1;
    private static final int MEAN_TEMP = 2;
    private static final int MIN_TEMP = 3;
    private static final int MONTH = 0;
    private static final int DAY = 1;
    private static final int YEAR = 2;
    private static final String FILE_ENCODING = "UTF-8";
    private static final String LINE_REGEX = ",";
    private static final String DATA_REGEX = "/";

    private int maxTemp;
    private int meanTemp;
    private int minTemp;


    public Weather takeThisDayWeather(String filename, LocalDate userData) throws IOException {
        clearTemp();
        File file = new File(filename);
        LineIterator fr = FileUtils.lineIterator(file, FILE_ENCODING);


        fr.next();
        String[] line;

        while (fr.hasNext()) {
            line = fr.nextLine().split(LINE_REGEX);
            if (isACorrectDay(userData, line[0])) {
                setAllTemp(line);
                return new Weather(minTemp, maxTemp, meanTemp);
            }
        }
        return null;
    }

    public Weather extremeTempBetween(LocalDate startData, LocalDate endData, String fileName) throws IOException {
        File file = new File(fileName);
        LineIterator fu = FileUtils.lineIterator(file, FILE_ENCODING);
        fu.next();
        String[] line;
        clearTemp();
        while (fu.hasNext()) {
            line = fu.nextLine().split(LINE_REGEX);
            if (getLocalDate(line[0]).isAfter(startData)) {
                if (getLocalDate(line[0]).isBefore(endData)) {
                    lookAtTemp(line);
                }
            }
        }
        return new Weather(minTemp, maxTemp, meanTemp);
    }


    public long numberOfWarmerDays(int userMeanTemp, String fileName) throws IOException {
        long days = 0;
        File file = new File(fileName);
        LineIterator lineIterator = FileUtils.lineIterator(file, FILE_ENCODING);
        lineIterator.next();
        String[] line;

        while (lineIterator.hasNext()) {
            line = lineIterator.nextLine().split(LINE_REGEX);

            try {
                setMeanTemp(Integer.valueOf(line[MEAN_TEMP]));
            } catch (NumberFormatException e) {
                continue;
            }

            if (meanTemp > userMeanTemp) {
                days++;
            }
        }
        return days;
    }

    private boolean isACorrectDay(LocalDate date, String dataFromFile) {
        if (theSameMonth(date, dataFromFile)) {
            if (theSameDay(date, dataFromFile)) {
                return theSameYear(date, dataFromFile);
            }
        }
        return false;
    }

    private boolean theSameMonth(LocalDate userData, String fromFileData) {
        String[] temp = getSplit(fromFileData);
        return userData.getMonthValue() == Integer.valueOf(temp[0]);
    }

    private boolean theSameDay(LocalDate userData, String fromFileData) {
        String[] temp = getSplit(fromFileData);
        return userData.getDayOfMonth() == Integer.valueOf(temp[1]);
    }

    private boolean theSameYear(LocalDate userData, String fromFileData) {
        String[] temp = getSplit(fromFileData);
        return userData.getYear() == Integer.valueOf(temp[2]);
    }

    private String[] getSplit(String fromFileData) {
        return fromFileData.split(DATA_REGEX);
    }

    private void clearTemp() {
        minTemp = Integer.MAX_VALUE;
        maxTemp = Integer.MIN_VALUE;
        meanTemp = Integer.MIN_VALUE;
    }

    private void setAllTemp(String[] line) {
        maxTemp = Integer.valueOf(line[MAX_TEMP]);
        meanTemp = Integer.valueOf(line[MEAN_TEMP]);
        minTemp = Integer.valueOf(line[MIN_TEMP]);
    }


    private LocalDate getLocalDate(String dataFromFile) {
        String[] temp = getSplit(dataFromFile);
        int day = Integer.valueOf(temp[DAY]);
        int month = Integer.valueOf(temp[MONTH]);
        int year = Integer.valueOf(temp[YEAR]);
        return LocalDate.of(year, month, day);
    }

    private void lookAtTemp(String[] line) {
        int temp = Integer.valueOf(line[MIN_TEMP]);
        if (minTemp > temp) {
            setMinTemp(temp);
        }
        temp = Integer.valueOf(line[MEAN_TEMP]);
        if (temp > meanTemp) {
            setMeanTemp(temp);
        }
        temp = Integer.valueOf(line[MAX_TEMP]);
        if (temp > maxTemp) {
            setMaXTemp(temp);
        }

    }


    private void setMinTemp(int temp) {
        minTemp = temp;
    }

    private void setMaXTemp(int temp) {
        maxTemp = temp;
    }

    private void setMeanTemp(int temp) {
        meanTemp = temp;
    }
}
