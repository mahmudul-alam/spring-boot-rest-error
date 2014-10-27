package globant.svp.core.service;

import globant.svp.core.dao.GenericDAO;
import globant.svp.core.domain.Entity;
import globant.svp.core.exception.ValidationException;
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
		Map<String, String> requestParam = new HashMap();

		// validate before persist
		CustomerValidation validation = new CustomerValidation();

		// validate customer exist or not
		// validation.isCustomerExist();

		// some more validation
		// validation.validationMethodThatThrowServerError();

		// some more validation and add all the validation together

		ValidationException exception = new ValidationException();

		try {
			validation.validationMethod1();
		} catch (ValidationException ex) {
			exception.addErrorMessages(ex.getErrorMessage());
		}

		try {
			validation.validationMethod2();
		} catch (ValidationException ex) {
			exception.addErrorMessages(ex.getErrorMessage());
		}

		throw exception;

		/*
		 * requestParam.put("ACCOUNT", new Long(((Customer)
		 * entity).getAccount()).toString()); if
		 * (genericDAO.getAllEntityByRequestParam(requestParam).size() > 0) {
		 * throw new CustomerExistException("Resoure Already Exist"); } else {
		 * genericDAO.addEntity(entity); }
		 */
		// return entity;
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
