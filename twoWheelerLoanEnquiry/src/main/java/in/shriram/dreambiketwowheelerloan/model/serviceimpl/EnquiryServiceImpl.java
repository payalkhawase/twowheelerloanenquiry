package in.shriram.dreambiketwowheelerloan.model.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.repository.EnquiryRepo;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	EnquiryRepo er;

	@Override
	public Enquiry getEnquiry(int customerId) {
		// TODO Auto-generated method stub
		return er.findById(customerId).get();
	}
}
