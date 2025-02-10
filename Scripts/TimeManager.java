package Scripts;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public final class TimeManager {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public LocalDateTime CalculateRentTime(double rentTime, LocalDateTime start) {
        return (start.plusHours((long) rentTime).plusMinutes(Math.round((rentTime - (long) rentTime) * 60)));
    }

    public double CalculateTimeLeft(LocalDateTime start, LocalDateTime end, double duration) {
        long secondsPassed = Duration.between(start, LocalDateTime.now()).getSeconds();
        double hoursPassed = secondsPassed / 3600.0;
        double remainingHours = duration - hoursPassed;

        return remainingHours;
    }

    public DateTimeFormatter GetDateFormat() {
        return dateFormat;
    }
}
