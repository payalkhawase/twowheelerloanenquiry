package in.shriram.dreambiketwowheelerloan.model.servicei;

import java.util.List;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

public interface EnquiryService {

	public Enquiry getEnquiry(int customerId);

	public Enquiry setAllData(Enquiry e);

	public List<Enquiry> getAllEnquiry();

	public Enquiry delete(int customerId);

	public Enquiry updateEnquiry(Enquiry e);

	public List<Cibil> ShowRejectedEnquiry(String status);

	public Enquiry updateEnquiryStatus(int customerId, String status);

	public Enquiry getEnquiryByCibil(int cbCibilId);


	

	
}
