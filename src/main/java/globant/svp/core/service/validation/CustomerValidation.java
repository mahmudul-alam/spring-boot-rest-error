package globant.svp.core.service.validation;

import globant.svp.core.exception.CustomerExistException;
import globant.svp.core.exception.ServerException;
import globant.svp.core.exception.ValidationException;

public class CustomerValidation {

	public void validationMethod1() {
		ValidationException ex = new ValidationException();
		ex.addErrorMessages("Some First Attribute",
				"Some First Attribute validation failed");
		throw ex;
	}

	public void validationMethod2() {
		ValidationException ex = new ValidationException();
		ex.addErrorMessages("Some other validation failed");
		throw ex;
	}

	public void isCustomerExist() {
		throw new CustomerExistException("Resource Already Exist");

	}

	public void validationMethodThatThrowServerError() {
		throw new ServerException("Internal Server Error");

	}

}
