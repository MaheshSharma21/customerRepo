package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Service.customerServiceI;
import com.BikkadIT.model.customer;

@RestController
public class customerController {

	@Autowired
	private customerServiceI CustomerServiceI;

	@PostMapping(value = "/savedatabyid", consumes = "application/json")
	public ResponseEntity<String> savedata(@RequestBody customer cus) {

		boolean savedata = CustomerServiceI.savedata(cus);
		if (savedata) {
			String msg = "Customer Saved successfully in database";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			String msg = "customer not saved ";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/saveall", consumes = "application/json")
	public ResponseEntity<String> saveall(@RequestBody List<customer> list) {
		boolean saveall = CustomerServiceI.saveall(list);
		if (saveall) {
			return new ResponseEntity<String>("data saved successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("data  not saved", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/getdatabyusingrequestparam", produces = "application/json")
	public ResponseEntity<customer> datacheck2(@RequestParam Integer cusid) {

		customer cusob = CustomerServiceI.getbyidusingrequestParam(cusid);

		if (cusob.getCusid() == cusid) {

			return new ResponseEntity<customer>(cusob, HttpStatus.OK);
		}

		return null;
	}

	@GetMapping(value = "/getdatabyusingPathVariable/{cusid}", produces = "application/json")
	public ResponseEntity<customer> getdatabyPathVariable(@PathVariable Integer cusid) {
		customer cudobj = CustomerServiceI.getbyidusingPathvariable(cusid);
		if (cudobj.getCusid() == cusid) {
			return new ResponseEntity<customer>(cudobj, HttpStatus.FOUND);
		}
		return null;

	}

	@GetMapping(value = "/getdatabyusingRequestbody", consumes = "application/json", produces = "application/json")
	public ResponseEntity<customer> getdatabyusingRequestbody(@RequestBody customer cus) {
		customer requestbody = CustomerServiceI.getbyobjectusingRequestbody(cus);
		int cusid = cus.getCusid();
		if (requestbody.getCusid() == cusid) {
			return new ResponseEntity<customer>(requestbody, HttpStatus.FOUND);
		}
		return null;
	}

	@GetMapping(value = "/getalldata", produces = "application/json")
	public ResponseEntity<List<customer>> getalldata() {

		List<customer> list = CustomerServiceI.getalldata();

		if (list != null) {
			return new ResponseEntity<List<customer>>(list, HttpStatus.OK);
		}
		return null;

	}

	@PutMapping(value = "/updateddatabyid", consumes = "application/json")
	public ResponseEntity<String> updatabyid(@RequestBody customer cus) {
		boolean updatebyid1 = CustomerServiceI.updatebyid(cus);
		if (updatebyid1) {
			return new ResponseEntity<String>("data updated successfully", HttpStatus.CREATED);
		} else {

			return new ResponseEntity<String>("data not  updated ", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updatemultiple", consumes = "application/json")
	public ResponseEntity<String> updatemultiple(@RequestBody List<customer> list) {
		boolean updatemultiple = CustomerServiceI.updatemultiple(list);
		if (updatemultiple) {
			return new ResponseEntity<String>("data updated successfully", HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("data  not updated ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deletebyid")
	public ResponseEntity<String> deletebyid(@RequestParam Integer cusid) {
		boolean deletebyid = CustomerServiceI.deletebyid(cusid);

		if (deletebyid) {
			String msg = "Record deleted  ";
			new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String msg = "record not deleted";
			new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
		return null;

	}

	@DeleteMapping( "/deletealldata")
	public ResponseEntity<String> deleteall() {
		boolean deleteall = CustomerServiceI.deleteall();
		if (deleteall) {
			String msg = "all data deleted";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String msg = "data not deleted";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

}
