package in.shriram.dreambiketwowheelerloan.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryService es;
	
	@PostMapping("/add")
	public ResponseEntity<Enquiry> setAllData(@RequestBody Enquiry e){
		
		Enquiry en=es.setAllData(e);
		
		return new ResponseEntity<Enquiry>(en,HttpStatus.CREATED);
		
	}
}
