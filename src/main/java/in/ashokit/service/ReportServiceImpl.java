package in.ashokit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.binding.SearchRequest;
import in.ashokit.binding.SearchResponse;
import in.ashokit.entity.EligibilityDtlsEntity;
import in.ashokit.repository.IEligibiityDtlsRepo;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IEligibiityDtlsRepo repo;
	private LocalDate endDate;
	private List<EligibilityDtlsEntity> findAll;



	@Override
	public List<String> getDistinctPlanNames() {
		return repo.getPlanNames();
		}

	@Override
	public List<String> getDistinctPlanStatus() {
		return repo.getPlanStatus();
	}
	List<EligibilityDtlsEntity> allRecords;

	@Override
	public List<SearchResponse> getSearchResults(SearchRequest request) {
		if(isRequestEmpty( request)) {
			 allRecords= repo.findAll();
			}
			else {
				String planName=request.getPlanName();
				String planStatus=request.getPlanStatus();
				LocalDate startDate = request.getStartDate();
			LocalDate  endDate = request.getEndDate();
			EligibilityDtlsEntity entity=new EligibilityDtlsEntity();
			
			if(planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			}
			
	    if(planStatus != null && !planStatus.equals("") ){
				entity.setPlanStatus(planStatus);
			}
	    
			if(startDate!= null && endDate!=null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}
	
			Example<EligibilityDtlsEntity> example=Example.of(entity);
				allRecords = repo.findAll(example);//It will generate Dynamic Query if property is available in entity then it will add that property to where clause
			
		}
			
			List<SearchResponse> response=new ArrayList<SearchResponse>();
			for(EligibilityDtlsEntity record: allRecords ) {
				SearchResponse sr =new SearchResponse();
				BeanUtils.copyProperties(record, sr);
				response.add(sr);
			}
	   return response;
	
	}
	private boolean isRequestEmpty(SearchRequest request) {
		if(request.getPlanName()!= null && !(request.getPlanName()==""))
			return false;
		else if(request.getPlanStatus()!= null && !(request.getPlanStatus()==""))
			return false;
		else if(request.getStartDate()!= null )
			return false;
		else if(request.getEndDate()!= null)
			return false;
		else
			return true;
	}

	@Override
	public List<SearchResponse> getSearchResult() {
		allRecords =repo.findAll();
		List<SearchResponse> response=new ArrayList<SearchResponse>();
		for(EligibilityDtlsEntity record: allRecords ) {
			SearchResponse sr =new SearchResponse();
			BeanUtils.copyProperties(record, sr);
			response.add(sr);
		}
   return response;
		
	}
	
}