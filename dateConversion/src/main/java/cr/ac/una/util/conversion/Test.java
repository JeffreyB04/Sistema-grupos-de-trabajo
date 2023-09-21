package cr.ac.una.util.conversion;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) {
        LocalDateTime hoy = LocalDateTime.now();
        System.out.printf("LocalDateTime   : %s%n", hoy);
        System.out.println();

        Timestamp ts = Timestamp.valueOf(hoy);
        System.out.printf("Timestamp       : %s%n", ts);
        System.out.printf("java.util.Date  : %s%n",
                DateConversion.timestamp2Util(ts));
        System.out.printf("java.sql.Date   : %s%n",
                new java.sql.Date(DateConversion.timestamp2Util(ts).getTime()));
    }

}
