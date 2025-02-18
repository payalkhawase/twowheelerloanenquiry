package in.shriram.dreambiketwowheelerloan.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry, Integer>{

	@Query("FROM Enquiry WHERE customerId = ?1")
	public Enquiry findByCustomerId(int customerId);

}
