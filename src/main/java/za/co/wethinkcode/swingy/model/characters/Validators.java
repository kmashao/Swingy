package za.co.wethinkcode.swingy.model.characters;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validators {

	public Validator validator(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator validator;
		validator = factory.getValidator();
		return validator;
	}
}
