package in.ashokit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.SearchRequest;
import in.ashokit.binding.SearchResponse;
import in.ashokit.reports.ExcelGenerator;
import in.ashokit.reports.PdfGenerator;
import in.ashokit.service.IReportService;

@RestController
public class ReportRestController {
	@Autowired
	private  IReportService service;
	
	@GetMapping("/plan_name")
	public List<String> getPlanNames(){
		return service.getDistinctPlanNames();
	}
	@GetMapping("/plan_status")
	public List<String> getPlanStatuses(){
		 List<String> statuses=service.getDistinctPlanStatus();
		return statuses;
	}
@GetMapping("/excel")
	public  void  getExcelReport( HttpServletResponse httpResponse) throws Exception{
	
	httpResponse.setContentType("application/octet-stream");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Plans.xls";
	    httpResponse.setHeader(headerKey, headerValue);
	
	
		List<SearchResponse> records=service.getSearchResult();
		ExcelGenerator excel =new ExcelGenerator();
		excel.generateExcelReport(records , httpResponse);
		
	}
@GetMapping("/pdf")
public void getPdfReport(HttpServletResponse httpResponse) throws Exception{
	httpResponse.setContentType("application/pdf");
	String headerKey="Content-Disposition";
	String headerValue="attachment; filename=Plans.pdf";
	httpResponse.setHeader(headerKey, headerValue);
			
	List<SearchResponse> records=service.getSearchResult();
	PdfGenerator pdf=new PdfGenerator();
	pdf.generatePdf(records, httpResponse);
	
}
@PostMapping("/search")
public List<SearchResponse> search(@RequestBody SearchRequest request){
	return service.getSearchResults(request);
	
}
	
}
