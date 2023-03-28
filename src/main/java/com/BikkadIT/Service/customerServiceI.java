package com.BikkadIT.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.BikkadIT.model.customer;

public interface customerServiceI {

	public boolean savedata(customer cus);

	public boolean saveall(List<customer> list);

	public customer getbyidusingrequestParam(int cusid);

	public customer getbyidusingPathvariable(int cusid);

	public customer getbyobjectusingRequestbody(customer cus);

	public List<customer> getalldata();

	public boolean updatebyid(customer cus);

	public boolean updatemultiple(List<customer> list);

	public boolean deletebyid(int cusid);

	public boolean deleteall();

}
