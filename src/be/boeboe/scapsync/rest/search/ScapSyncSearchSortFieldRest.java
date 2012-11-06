/**
 * 
 */
package be.boeboe.scapsync.rest.search;

import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchSortField;

/**
 * @author boeboe
 *
 */
public class ScapSyncSearchSortFieldRest implements IScapSyncSearchSortField {
  private static String SELECTED = "selected";
  private static String NAME = "name";

  private boolean fSelected;
  private String fName;
  
  public ScapSyncSearchSortFieldRest(JSONObject scapSyncSearchSortFieldRest) {
    super();
    try {
      fSelected = Boolean.getBoolean(scapSyncSearchSortFieldRest.getString(SELECTED));
      fName = scapSyncSearchSortFieldRest.getString(NAME);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchSortField#getSelected()
   */
  @Override
  public boolean getSelected() {
    return fSelected;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearchSortField#getName()
   */
  @Override
  public String getName() {
    return fName;
  }
}
