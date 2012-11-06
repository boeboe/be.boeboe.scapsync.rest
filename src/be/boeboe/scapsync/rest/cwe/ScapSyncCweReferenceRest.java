/**
 * 
 */
package be.boeboe.scapsync.rest.cwe;

import java.net.URI;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.ScapSyncUtils;
import be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference;

/**
 * @author boeboe
 *
 */
public class ScapSyncCweReferenceRest implements IScapSyncCweReference {
  private static String URL = "url";
  private static String TITLE = "title";
  private static String EDITION = "edition";
  private static String SECTION = "section";
  private static String DATE = "date";
  private static String PUBLICATION_DATE = "publication_date";
  private static String AUTOR = "author";

  private URI fUrl;
  private String fTitle;
  private String fEdition;
  private String fSection;
  private Date fDate;
  private Date fPublicationDate;
  private String[] fAutors;

  public ScapSyncCweReferenceRest(JSONObject scapSyncCweReferenceRest) {
    super();
    try { 
      fUrl = URI.create(scapSyncCweReferenceRest.getString(URL));
      fTitle = scapSyncCweReferenceRest.getString(TITLE);
      fEdition = scapSyncCweReferenceRest.getString(EDITION);
      fSection = scapSyncCweReferenceRest.getString(SECTION);
      fDate = ScapSyncUtils.getDate(scapSyncCweReferenceRest.getString(DATE));
      fPublicationDate = ScapSyncUtils.getDate(
          scapSyncCweReferenceRest.getString(PUBLICATION_DATE));
      
      JSONArray authors = scapSyncCweReferenceRest.getJSONArray(AUTOR);
      fAutors = new String[authors.length()];
      for ( int i = 0 ; i < authors.length(); i++) {
        fAutors[i] = authors.getString(i);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
  
  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getUrl()
   */
  @Override
  public URI getUrl() {
    return fUrl;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getTitle()
   */
  @Override
  public String getTitle() {
    return fTitle;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getEdition()
   */
  @Override
  public String getEdition() {
    return fEdition;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getSection()
   */
  @Override
  public String getSection() {
    return fSection;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getDate()
   */
  @Override
  public Date getDate() {
    return fDate;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getPublicationDate()
   */
  @Override
  public Date getPublicationDate() {
    return fPublicationDate;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncCweReference#getAuthors()
   */
  @Override
  public String[] getAuthors() {
    return fAutors;
  }
}
