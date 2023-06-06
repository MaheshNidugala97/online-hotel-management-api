package com.sdp.hms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sdp.hms.entity.ValidPhoneNumber;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class PhoneNumberValidator implements 
ConstraintValidator<ValidPhoneNumber, String> {

  @Override
  public void initialize(ValidPhoneNumber contactNumber) {
  }


@Override
public boolean isValid(String value, ConstraintValidatorContext context) {
	// TODO Auto-generated method stub
	 return value != null && value.matches("(\\(?([\\d \\-\\)\\–\\+\\/\\(]+){6,}\\)?([ .\\-–\\/]?)([\\d]+))+")
	          && (value.length() > 8) && (value.length() < 14);
}

}