package globant.svp.core.service;

import globant.svp.core.dao.GenericDAO;
import globant.svp.core.domain.Customer;
import globant.svp.core.domain.Entity;
import globant.svp.core.exception.CustomerExistException;
import globant.svp.core.service.validation.CustomerValidation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerService implements GenericService {

	public CustomerService() {

	}

	@Autowired
	@Qualifier("CustomerDAOJDBC")
	private GenericDAO genericDAO;

	@Override
	public Entity addService(Entity entity) {

		// validate before persist
		// CustomerValidation validation = new CustomerValidation();

		// validate customer exist or not
		// validation.isCustomerExist();

		// some more validation
		// validation.validationMethodThatThrowServerError();

		
		Map<String, String> requestParam = new HashMap();
		requestParam.put("ACCOUNT",
				new Long(((Customer) entity).getAccount()).toString());
		if (genericDAO.getAllEntityByRequestParam(requestParam).size() > 0) {
			throw new CustomerExistException();
		} else {
			genericDAO.addEntity(entity);
		}
		return entity;
	}

	@Override
	public void deleteService(Entity entity) {
		genericDAO.deleteEntity(entity);
	}

	@Override
	public List<? extends Entity> getALlEntity() {
		return genericDAO.getAllEntity();
	}

	@Override
	public List<? extends Entity> getAllEntityByRequestParam(
			Map<String, String> requestParam) {
		return genericDAO.getAllEntityByRequestParam(requestParam);
	}

}
