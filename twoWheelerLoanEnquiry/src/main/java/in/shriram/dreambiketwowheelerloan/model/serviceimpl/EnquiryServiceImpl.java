package in.shriram.dreambiketwowheelerloan.model.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.exceptions.AgeLessThanException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongAdharCardNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongMobileNoException;
import in.shriram.dreambiketwowheelerloan.model.exceptions.WrongPancardNoException;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.repository.CibilRepo;
import in.shriram.dreambiketwowheelerloan.model.repository.EnquiryRepo;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepo er;

	@Autowired
	RestTemplate rt;

	@Autowired
	CibilRepo cr;

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
    	
		Cibil c = new Cibil();
		c.setCibilScore(c.getCibilScore());
		c.setCibilscoredDateTime(new Date());
		c.setStatus(c.getStatus());
		c.setCibilRemark(c.getCibilRemark());
		
		Cibil co = cr.save(c);
		
		e.setCb(co);
		rt.postForObject("http://localhost:7777/cibil/add", co, Cibil.class);
		Enquiry en=er.save(e);
		
		return en;

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

	@Override
	public List<Cibil> ShowRejectedEnquiry(String status) {
		
		Cibil c = new Cibil();
		
		c.setStatus(c.getStatus());
		
		return  cr.findByStatus(status);
	}

	@Override
	public Enquiry updateEnquiryStatus(int customerId, String status) {

		Enquiry e=new Enquiry();
		e=er.findById(customerId).get();
		
		e.setCustomerId(customerId);
		e.setFirstname(e.getFirstname());
		e.setLastName(e.getLastName());
		e.setAddress(e.getAddress());
		e.setCity(e.getCity());
		e.setAge(e.getAge());
		e.setEmail(e.getEmail());
		e.setMobileNo(e.getMobileNo());
		e.setAlternateMobno(e.getAlternateMobno());
		e.setPancardNo(e.getPancardNo());
		e.setAdharcardNo(e.getAdharcardNo());
		e.setEnquiryStatus(status);
		
		return er.save(e);
	}

	@Override
	public Enquiry getEnquiryByCibil(int cbCibilId) {
		
		return er.findByCbCibilId(cbCibilId);
	}	

}
