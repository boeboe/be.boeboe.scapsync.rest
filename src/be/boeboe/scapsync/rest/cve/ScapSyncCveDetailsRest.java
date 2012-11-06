/**
 * 
 */
package be.boeboe.scapsync.rest.cve;

import java.util.Arrays;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCveReference;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCvss;

/**
 * @author boeboe
 *
 */
public class ScapSyncCveDetailsRest implements IScapSyncCveDetails {
  private static String CVSS = "cvss";
  private static String CVSS_VECTOR = "cvss_vector";
  private static String CVSS_BASE_SCORE = "cvss_base_score";
  private static String VERSION_COUNT = "version_count";
  private static String UPSTREAM_MODIFIED = "upstream_modified";
  private static String UPSTREAM_PUBLISHED = "upstream_published";
  private static String SUMMARY = "summary";
  private static String REFERENCES = "references";
  private static String VERSION_URL = "version_url";
  
  private IScapSyncCvss fCvss;
  private String fCvssVector;
  private double fCvssBaseScore;
  private int fVersionCount;
  private Date fUpstreamModified;
  private Date fUpstreamPublished;
  private String fSummary;
  private IScapSyncCveReference[] fReferences;
  private String fVersionUrl;
  
  public ScapSyncCveDetailsRest(JSONObject scapSyncCveDetailsRest) {
    super();
    try {
      fCvss = new ScapSyncCveCvssRest(scapSyncCveDetailsRest.getJSONObject(CVSS));
      fCvssVector = scapSyncCveDetailsRest.getString(CVSS_VECTOR);
      fCvssBaseScore = scapSyncCveDetailsRest.getDouble(CVSS_BASE_SCORE);
      fVersionCount = scapSyncCveDetailsRest.getInt(VERSION_COUNT);
      fUpstreamModified = ScapSyncUtils.getDate(scapSyncCveDetailsRest.getString(UPSTREAM_MODIFIED));
      fUpstreamPublished = ScapSyncUtils.getDate(scapSyncCveDetailsRest.getString(UPSTREAM_PUBLISHED));
      fSummary = scapSyncCveDetailsRest.getString(SUMMARY);
      fVersionUrl = scapSyncCveDetailsRest.getString(VERSION_URL);
      
      JSONArray references = scapSyncCveDetailsRest.getJSONArray(REFERENCES);
      fReferences = new IScapSyncCveReference[references.length()];
      for ( int i = 0 ; i < references.length(); i++) {
        fReferences[i] =
            new ScapSyncCveReferenceRest(references.getJSONObject(i));
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getCvss()
   */
  @Override
  public IScapSyncCvss getCvss() {
    return fCvss;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getCvssVector()
   */
  @Override
  public String getCvssVector() {
    return fCvssVector;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getCvssBaseScore()
   */
  @Override
  public double getCvssBaseScore() {
    return fCvssBaseScore;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getVersionCount()
   */
  @Override
  public int getVersionCount() {
    return fVersionCount;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getUpstreamModifiedDate()
   */
  @Override
  public Date getUpstreamModifiedDate() {
    return fUpstreamModified;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getUpstreamPublishedDate()
   */
  @Override
  public Date getUpstreamPublishedDate() {
    return fUpstreamPublished;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getSummary()
   */
  @Override
  public String getSummary() {
    return fSummary;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getRefences()
   */
  @Override
  public IScapSyncCveReference[] getRefences() {
    return fReferences;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCveDetails#getVersionUrl()
   */
  @Override
  public String getVersionUrl() {
    return fVersionUrl;
  }

  @Override
  public String toString() {
    return "ScapSyncCveRest [fCvssVector=" + fCvssVector + ", fCvssBaseScore="
        + fCvssBaseScore + ", fVersionCount=" + fVersionCount
        + ", fUpstreamModified=" + fUpstreamModified + ", fUpstreamPublished="
        + fUpstreamPublished + ", fSummary=" + fSummary + ", fReferences="
        + Arrays.toString(fReferences) + "]";
  }
}
