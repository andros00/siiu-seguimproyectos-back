package seguimproyectos_back.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class DateUtil {
    static List<String> formatStrings = Arrays.asList("dd/MM/yyyy HH:mm:ss", "dd-MMM-yy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime tryParse(String dateString)
    {
        if (Objects.nonNull(dateString)) {
            for (String formatString : formatStrings) {
                try {
                    return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(formatString));
                } catch (DateTimeParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public static String formatDate(LocalDateTime date, Object... params) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (params.length == 1 && params[0] != null) {
            formatter = (DateTimeFormatter)params[0];
        }
        if (Objects.nonNull(date))
            return date.format(formatter);
        return null;
    }
}
