/**
 * 
 */
package be.boeboe.scapsync.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author boeboe
 *
 */
public class ScapSyncUtils {
  
  /**
   * getDate is a helper method to convert ScapSync Date Strings to java Date
   * objects. 
   *  Example: "2009-12-19T06:56:44Z" or "2012-06-09T03:14:52.417000Z" or
   *           "2008-03-25T19:16:29.693Z"
   * @param scapSyncDate
   * @return date the a Java Date object
   */
  public static Date getDate(String scapSyncDate) {
    String correctionPattern1 = "(.*)(\\.\\d{6})([Z])";
    String correctionPattern2 = "(.*)(\\.\\d{3})([Z])";
    if (scapSyncDate.matches(correctionPattern1)) {
      scapSyncDate = scapSyncDate.replaceAll(correctionPattern1, "$1$3");
    } else if (scapSyncDate.matches(correctionPattern2)) {
      scapSyncDate = scapSyncDate.replaceAll(correctionPattern2, "$1$3");
    }
    System.out.println(scapSyncDate);
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    Date date = new Date();
    try {
      date = formatter.parse(scapSyncDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }
  
}
