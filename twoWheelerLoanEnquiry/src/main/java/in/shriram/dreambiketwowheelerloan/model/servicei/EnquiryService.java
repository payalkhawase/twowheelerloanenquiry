package in.shriram.dreambiketwowheelerloan.model.servicei;

import java.util.List;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;

public interface EnquiryService {

	public Enquiry getEnquiry(int customerId);

	public Enquiry setAllData(Enquiry e);

	public Enquiry getAllEnquiry();
}
