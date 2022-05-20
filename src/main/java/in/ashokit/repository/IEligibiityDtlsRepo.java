package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.EligibilityDtlsEntity;

public interface IEligibiityDtlsRepo extends JpaRepository<EligibilityDtlsEntity, Integer> {
	
@Query("select distinct(planName) from EligibilityDtlsEntity")
	public List<String> getPlanNames();

@Query("select distinct(planStatus) from EligibilityDtlsEntity")
public List<String> getPlanStatus();
}
