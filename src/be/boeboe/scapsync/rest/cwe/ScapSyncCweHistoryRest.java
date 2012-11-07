package be.boeboe.scapsync.rest.cwe;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweHistoryRest implements IScapSyncCweHistory {
  private static String DATE = "date";
  private static String ORGANIZATION = "organization";
  private static String MODIFIER = "modifier";
  private static String COMMENT = "comment";

  private Date fDate;
  private String fOrganization;
  private String fModifier;
  private String fComment;

  public ScapSyncCweHistoryRest(JSONObject scapSyncCweHistoryRest) {
    super();
    try {
      fDate = ScapSyncUtils.getDate(scapSyncCweHistoryRest.getString(DATE));
      fOrganization = scapSyncCweHistoryRest.getString(ORGANIZATION);
      fModifier = scapSyncCweHistoryRest.getString(MODIFIER);
      fComment = scapSyncCweHistoryRest.getString(COMMENT);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory#getDate()
   */
  @Override
  public Date getDate() {
    return fDate;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory#getOrganization()
   */
  @Override
  public String getOrganization() {
    return fOrganization;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory#getModifier()
   */
  @Override
  public String getModifier() {
    return fModifier;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweHistory#getComment()
   */
  @Override
  public String getComment() {
    return fComment;
  }
}
