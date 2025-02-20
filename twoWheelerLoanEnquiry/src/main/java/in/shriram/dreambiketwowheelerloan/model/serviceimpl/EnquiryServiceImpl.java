package in.shriram.dreambiketwowheelerloan.model.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shriram.dreambiketwowheelerloan.model.exceptions.AgeLessThanException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongAdharCardNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongMobileNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongPancardNoException;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.repository.EnquiryRepo;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	EnquiryRepo er;

	@Override
	public Enquiry getEnquiry(int customerId) {
		
		return er.findById(customerId).get();
  }
	
    public Enquiry setAllData(Enquiry e) {
	
    	if(e.getAge()<18) {
    		
    		throw new AgeLessThanException("Age is less than 18");
    	}
    	
		
		  String mno=String.valueOf(e.getMobileNo());
		  if(mno.length()!=10 ||!mno.matches("\\d{10}")) {
		  
		  throw new WrongMobileNoException("wrong mobile number");
		  }
		 
		  String adhar=String.valueOf(e.getAdharcardNo()); 
		  if(adhar.length()!=12 ||!adhar.matches("\\d{12}")) {
		
		   throw new WrongAdharCardNoException("wrong AdharCard number"); 
		 }
		
		 String regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}";
		 
		  if(regexp.matches(e.getPancardNo())) {
		 
		   throw new WrongPancardNoException("wrong pancardNo");
		 }
		 
		return er.save(e); 
	}
	@Override
	public List<Enquiry> getAllEnquiry() {
		
		return er.findAll();
	}
	
	@Override
	public Enquiry delete(int customerId) {
		er.deleteById(customerId);
		return null;
		
	}
	@Override
	public Enquiry updateEnquiry(Enquiry e) {
		return er.save(e);
	}
	

	
}
