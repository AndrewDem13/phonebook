package com.demyanenko.phonebook.validator;

import com.demyanenko.phonebook.model.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ContactsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Contact.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Contact contact = (Contact) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middle_name", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number_mob", "Required");

        if (contact.getLast_name().length() < 4) {
            errors.rejectValue("last_name", "Size.contactForm.name");
        }
        if (contact.getFist_name().length() < 4) {
            errors.rejectValue("first_name", "Size.contactForm.name");
        }
        if (contact.getMiddle_name().length() < 4) {
            errors.rejectValue("middle_name", "Size.contactForm.name");
        }
        if (!numberValid(contact.getNumber_mob())) {
            errors.rejectValue("number_mob", "Invalid.userForm.number");
        }
        if (contact.getNumber_home() != null && !numberValid(contact.getNumber_home())) {
            errors.rejectValue("number_home", "Invalid.userForm.number");
        }
        if (contact.getEmail() != null && !emailValid(contact.getEmail())) {
            errors.rejectValue("email", "Invalid.userForm.email");
        }
    }

    private static boolean numberValid(String s) {
        s = s.trim();
        if (s.length() < 10 || (s.charAt(0)=='+' && !s.substring(1, 4).equals("380")))
            return false;

        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 48 && s.charAt(i) <= 57) || (i == 0 && s.charAt(i) == '+'))
                temp += s.charAt(i);
            else
                return false;
        }

        if ((temp.charAt(0) == '+' && temp.length() == 13) || (temp.charAt(0) == '0' && temp.length() == 10))
            return true;

        return false;
    }

    private static boolean emailValid(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
