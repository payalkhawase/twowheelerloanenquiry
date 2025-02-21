package in.shriram.dreambiketwowheelerloan.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shriram.dreambiketwowheelerloan.model.model.Cibil;
import in.shriram.dreambiketwowheelerloan.model.model.Enquiry;
import in.shriram.dreambiketwowheelerloan.model.servicei.EnquiryService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/enq")
@Slf4j
public class EnquiryController {

	@Autowired
	EnquiryService es;	
	
	@GetMapping("/getLog")
	public void getLog() {
		
		log.error("THIS IS ERROR LOG");
	}
	
	@PostMapping("/add")
	public ResponseEntity<Enquiry> setAllData(@RequestBody Enquiry e){
		
		Enquiry en=es.setAllData(e);
		
		return new ResponseEntity<Enquiry>(en,HttpStatus.CREATED);
	}
	

	@GetMapping("/enquiry")
	public ResponseEntity<List<Enquiry>> getAllEnquiry(){
		
		//log.info("this is info log");
		
		List<Enquiry> eq = es.getAllEnquiry();
		
		return new ResponseEntity<List<Enquiry>>(eq, HttpStatus.OK);
	}
	
	@GetMapping("enquiry/{customerId}")
	public ResponseEntity<Enquiry> getEnquirySingle(@PathVariable("customerId") int customerId) {
		
		Enquiry eo = es.getEnquiry(customerId);
		
		return new ResponseEntity<Enquiry>(eo, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Enquiry> updateEnquirySingle(@RequestBody Enquiry e)
	{
		Enquiry er=es.updateEnquiry(e);
		
		return new ResponseEntity<Enquiry>(er,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Enquiry> delete(@PathVariable("customerId") int customerId){
		
		Enquiry er=	es.delete(customerId);
		
		return new ResponseEntity<Enquiry>(er, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/rejectedEnquiry/{status}")
	public ResponseEntity<List<Cibil>> showrejectedEnquiry(@PathVariable("status") String status) {
		
		List<Cibil> cb = es.ShowRejectedEnquiry(status);
		
		return new ResponseEntity<List<Cibil>>(cb, HttpStatus.OK);
	
    }
}
	
