package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.SearchRequest;
import in.ashokit.binding.SearchResponse;

public interface IReportService {
	
	public List<String> getDistinctPlanNames();
	public List<String> getDistinctPlanStatus();
	public List<SearchResponse> getSearchResults(SearchRequest request);
	public List<SearchResponse> getSearchResult();

}
