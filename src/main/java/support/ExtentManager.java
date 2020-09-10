package support;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ExtentManager {

    static ExtentReports extent;
    final static String filePath = System.getProperty("user.dir") + "/reports/";

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath + getDataHora() + ".html", true);
        }

        return extent;
    }

    private static String getDataHora(){
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy_hh.mm");

        return formatter.format(calendar.getTime());

    }
}
