package com.BikkadIT.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.dao.customerRepository;
import com.BikkadIT.model.customer;

@Service
public class customerServiceImpl implements customerServiceI {

	@Autowired
	private customerRepository CustomerRepository;

	@Override
	public boolean savedata(customer cus) {
		customer customer = CustomerRepository.save(cus);
		if (customer != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean saveall(List<customer> list) {

		List<customer> saveAll = CustomerRepository.saveAll(list);
		if (saveAll != null) {
			return true;
		}

		return false;

	}

	@Override
	public customer getbyidusingrequestParam(int cusid) {
		customer customer = CustomerRepository.findById(cusid).get();
		if (customer != null) {
			return customer;
		}
		return null;
	}

	@Override
	public customer getbyidusingPathvariable(int cusid) {
		customer customer = CustomerRepository.findById(cusid).get();
		if (customer != null) {
			return customer;
		}
		return null;
	}

	@Override
	public customer getbyobjectusingRequestbody(customer cus) {
		int cusid = cus.getCusid();
		customer findById = CustomerRepository.findById(cusid).get();
		return findById;
	}

	@Override
	public List<customer> getalldata() {
		List<customer> findAll = CustomerRepository.findAll();
		return findAll;
	}

	@Override
	public boolean updatebyid(customer cus) {
		boolean existsById = CustomerRepository.existsById(cus.getCusid());
		if (existsById) {
			CustomerRepository.save(cus);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatemultiple(List<customer> list) {
		List<customer> findAll = CustomerRepository.findAll();
		if (findAll != null) {
			CustomerRepository.saveAll(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletebyid(int cusid) {

		boolean byId = CustomerRepository.existsById(cusid);
		if (byId) {
			CustomerRepository.deleteById(cusid);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteall() {
		List<customer> findAll = CustomerRepository.findAll();
		if (findAll != null) {
			CustomerRepository.deleteAll();
			return true;
		} else {
			return false;
		}
	}

}
