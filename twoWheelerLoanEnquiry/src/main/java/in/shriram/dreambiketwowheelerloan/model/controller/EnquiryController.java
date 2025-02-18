package in.shriram.dreambiketwowheelerloan.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryService es;
	
	public ResponseEntity<Enquiry> setAllData(@RequestBody Enquiry e){
		
		return null;
		
	}
}
