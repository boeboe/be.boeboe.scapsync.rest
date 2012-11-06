/**
 * 
 */
package be.boeboe.scapsync.rest.search;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResultType;

/**
 * @author boeboe
 *
 */
public class ScapSyncSearchResultRest implements IScapSyncSearchResult {
  private static String ID = "id";
  private static String SUMMARY_TEXT = "summary_text";
  private static String TITLE_TEXT = "title_text";
  private static String TYPE = "type";
  private static String URL = "url";
  private static String MODIFIED_DATE = "modified";

  private String fId;
  private String fSummaryText;
  private String fTitleText;
  private String fUrl;
  private IScapSyncSearchResultType fType;
  private Date fModifiedDate;
  
  public ScapSyncSearchResultRest(JSONObject scapSyncSearchResultRest) {
    super();
    try {
      fId = scapSyncSearchResultRest.getString(ID);
      fSummaryText = scapSyncSearchResultRest.getString(SUMMARY_TEXT);
      fTitleText = scapSyncSearchResultRest.getString(TITLE_TEXT);
      fUrl = scapSyncSearchResultRest.getString(URL);
      fType = IScapSyncSearchResultType.fromString(scapSyncSearchResultRest.getString(TYPE));
      fModifiedDate = ScapSyncUtils.getDate(scapSyncSearchResultRest.getString(MODIFIED_DATE));
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult#getId()
   */
  @Override
  public String getId() {
    return fId;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult#getSummaryText()
   */
  @Override
  public String getSummaryText() {
    return fSummaryText;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult#getTitleText()
   */
  @Override
  public String getTitleText() {
    return fTitleText;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult#getUrl()
   */
  @Override
  public String getUrl() {
    return fUrl;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult#getType()
   */
  @Override
  public IScapSyncSearchResultType getType() {
    return fType;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult#getModifiedDate()
   */
  @Override
  public Date getModifiedDate() {
    return fModifiedDate;
  }

  @Override
  public String toString() {
    return "ScapSyncSearchResultRest [fId=" + fId + ", fSummaryText="
        + fSummaryText + ", fTitleText=" + fTitleText + ", fUrl=" + fUrl
        + ", fType=" + fType + ", fModifiedDate=" + fModifiedDate + "]";
  }
}
