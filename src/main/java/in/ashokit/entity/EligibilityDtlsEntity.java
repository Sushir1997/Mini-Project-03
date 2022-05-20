package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="ELIGIBILITY_DTLS")
public class EligibilityDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private Integer planId;
	@Column(name="CASE_NUM")
	private Integer caseNo;
	@Column(name="PLAN_NAME")
	private String planName;
	@Column(name="PLAN_STATUS")
	private String planStatus;
	@Column(name="HOLDER_NAME")
	private String holderName;
	@Column(name="HOLDER_SSN")
	private Integer holderSsn;
	@Column(name="BENEFIT_AMT")
	private Float benefitAmt;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@Column(name="END_DATE")
	private LocalDate endDate;
	@Column(name="DENIAL_REASN")
	private String DenialReason;
	
	
}
