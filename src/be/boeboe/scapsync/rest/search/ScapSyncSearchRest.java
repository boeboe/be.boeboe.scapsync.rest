/**
 * 
 */
package be.boeboe.scapsync.rest.search;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import be.boeboe.scapsync.rest.interfaces.IScapSyncSearch;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchFacet;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchPage;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchResult;
import be.boeboe.scapsync.rest.interfaces.IScapSyncSearchSortField;

/**
 * @author boeboe
 *
 */
public class ScapSyncSearchRest implements IScapSyncSearch {
  private static String ROWS_PER_PAGE = "rows_per_page";
  private static String SORT_FIELDS = "sort_fields";
  private static String START_ROW = "start_row";
  private static String TOTAL_ROWS = "total_rows";
  private static String FACETS = "facets";
  private static String CURRENT_PAGE = "current_page";
  private static String RESULS = "results";
  private static String END_ROW = "end_row";
  private static String SEARCH_URL = "search_url";
  private static String PAGES = "pages";

  private int fRowsPerPage;
  private IScapSyncSearchSortField[] fSortFields;
  private int fStartRow;
  private int fTotalRows;
  private IScapSyncSearchFacet[] fFacets;
  private int fCurrentPage;
  private IScapSyncSearchResult[] fResults;
  private int fEndRow;
  private String fSearchUrl;
  private IScapSyncSearchPage[] fPages;
  
  public ScapSyncSearchRest(JSONObject scapSyncSearchRest) {
    super();
    try {
      fRowsPerPage = scapSyncSearchRest.getInt(ROWS_PER_PAGE);
      fStartRow = scapSyncSearchRest.getInt(START_ROW);
      fTotalRows = scapSyncSearchRest.getInt(TOTAL_ROWS);
      fCurrentPage = scapSyncSearchRest.getInt(CURRENT_PAGE);
      fEndRow = scapSyncSearchRest.getInt(END_ROW);
      fSearchUrl = scapSyncSearchRest.getString(SEARCH_URL);
      
      JSONArray sortFields = scapSyncSearchRest.getJSONArray(SORT_FIELDS);
      fSortFields = new IScapSyncSearchSortField[sortFields.length()];
      for ( int i = 0 ; i < sortFields.length(); i++) {
        fSortFields[i] =
            new ScapSyncSearchSortFieldRest(sortFields.getJSONObject(i));
      }

      JSONArray results = scapSyncSearchRest.getJSONArray(RESULS);
      fResults = new IScapSyncSearchResult[results.length()];
      for ( int i = 0 ; i < results.length(); i++) {
        fResults[i] =
            new ScapSyncSearchResultRest(results.getJSONObject(i));
      }

      JSONArray pages = scapSyncSearchRest.getJSONArray(PAGES);
      fPages = new IScapSyncSearchPage[pages.length()];
      for ( int i = 0 ; i < pages.length(); i++) {
        fPages[i] =
            new ScapSyncSearchPageRest(pages.getJSONObject(i));
      }

      List<IScapSyncSearchFacet> facetList = new ArrayList<IScapSyncSearchFacet>();
      JSONArray facetGroups = scapSyncSearchRest.getJSONArray(FACETS);
      for (int i = 0; i< facetGroups.length(); i++) {
        JSONObject thisFacetGroup = facetGroups.getJSONObject(i);
        String baseFacetName = thisFacetGroup.getString(ScapSyncSearchFacetRest.NAME);
        JSONArray facets = thisFacetGroup.getJSONArray(ScapSyncSearchFacetRest.VALUES);
        for ( int j = 0 ; j < facets.length(); j++) {
          facetList.add(new ScapSyncSearchFacetRest(facets.getJSONObject(j), baseFacetName));
        }
      }
      fFacets = facetList.toArray(new IScapSyncSearchFacet[facetList.size()]);

    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   *  (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getSearchUrl()
   */
  @Override
  public String getSearchUrl() {
    return fSearchUrl;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getRowsPerPage()
   */
  @Override
  public int getRowsPerPage() {
    return fRowsPerPage;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getStartRow()
   */
  @Override
  public int getStartRow() {
    return fStartRow;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getEndRow()
   */
  @Override
  public int getEndRow() {
    return fEndRow;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getTotalRows()
   */
  @Override
  public int getTotalRows() {
    return fTotalRows;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getCurrentPage()
   */
  @Override
  public int getCurrentPage() {
    return fCurrentPage;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getSortFields()
   */
  @Override
  public IScapSyncSearchSortField[] getSortFields() {
    return fSortFields;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getFacets()
   */
  @Override
  public IScapSyncSearchFacet[] getFacets() {
    return fFacets;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getResults()
   */
  @Override
  public IScapSyncSearchResult[] getResults() {
    return fResults;
  }

  /** (non-Javadoc)
   * @see be.boeboe.scapsync.rest.interfaces.IScapSyncSearch#getPages()
   */
  @Override
  public IScapSyncSearchPage[] getPages() {
    return fPages;
  }
}
