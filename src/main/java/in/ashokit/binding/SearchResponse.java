package in.ashokit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {
	private Integer caseNo;	
	private String planName;
	private String planStatus;
	private String holderName;
	private Integer holderSsn;
	private Float benefitAmt;
	private LocalDate startDate;
	private LocalDate endDate;
	private String DenialReason;
	
}
