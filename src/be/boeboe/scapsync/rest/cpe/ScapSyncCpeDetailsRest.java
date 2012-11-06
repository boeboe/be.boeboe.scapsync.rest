package be.boeboe.scapsync.rest.cpe;

import java.util.Arrays;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails;

public class ScapSyncCpeDetailsRest implements IScapSyncCpeDetails {
  private static String STATUS = "status";
  private static String NAME = "name";
  private static String VERSION_COUNT = "version_count";
  private static String UPSTREAM_MODIFIED = "upstream_modified";
  private static String TITLES = "titles";
  private static String VERSION_URL = "version_url";
  
  private String fStatus;
  private String fName;
  private String fVersionCount;
  private Date fUpstreamModified;
  private String[] fTitles;
  private String fVersionUrl;
  
  public ScapSyncCpeDetailsRest(JSONObject scapSyncCpeDetailsRest) {
    super();
    try {
      fStatus = scapSyncCpeDetailsRest.getString(STATUS);
      fName = scapSyncCpeDetailsRest.getString(NAME);
      fVersionCount = scapSyncCpeDetailsRest.getString(VERSION_COUNT);
      fUpstreamModified = ScapSyncUtils.getDate(
          scapSyncCpeDetailsRest.getString(UPSTREAM_MODIFIED));
      fVersionUrl = scapSyncCpeDetailsRest.getString(VERSION_URL);
      
      JSONArray titles = scapSyncCpeDetailsRest.getJSONArray(TITLES);
      fTitles = new String[titles.length()];
      for (int i = 0; i < titles.length() ; i++) {
        fTitles[i] = titles.getString(i);        
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails#getStatus()
   */
  @Override
  public String getStatus() {
    return fStatus;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails#getName()
   */
  @Override
  public String getName() {
    return fName;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails#getVersionCount()
   */
  @Override
  public String getVersionCount() {
    return fVersionCount;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails#getUpstreamModfied()
   */
  @Override
  public Date getUpstreamModfied() {
    return fUpstreamModified;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails#getTitles()
   */
  @Override
  public String[] getTitles() {
    return fTitles;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCpeDetails#getVersionUrl()
   */
  @Override
  public String getVersionUrl() {
    return fVersionUrl;
  }

  @Override
  public String toString() {
    return "ScapSyncCpeDetailsRest [fStatus=" + fStatus + ", fName=" + fName
        + ", fVersionCount=" + fVersionCount + ", fUpstreamModified="
        + fUpstreamModified + ", fTitles=" + Arrays.toString(fTitles)
        + ", fVersionUrl=" + fVersionUrl + "]";
  }
}
