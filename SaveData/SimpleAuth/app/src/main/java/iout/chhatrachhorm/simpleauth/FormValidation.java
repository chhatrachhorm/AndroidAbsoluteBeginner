package iout.chhatrachhorm.simpleauth;

import java.util.regex.Pattern;

/**
 * Created by chhatra on 10/6/2017.
 *
 */

class FormValidation {
    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern SYMBOL = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
    static String[] emailPassValidation(String email, String password){
        String res[] = new String[2];
        res[0] = "invalid";
        if(email.isEmpty() || password.isEmpty()){
            res[1] = "Please Input all the Fields";
        }else if(email.length() > 40) {
            res[1] = "The length of the email must not exceed 40 characters";
        }else if(!VALID_EMAIL.matcher(email).matches()){
            res[1] = "The email is invalid";
        }else if(password.length() < 6){
            res[1] = "The password must not less than 6 characters";
        }else if(!password.matches(".*\\d.*")){
            res[1] = "The password must contain at least one number";
        }else if(!SYMBOL.matcher(password).find()){
            res[1] = "The password must contain at least one special character";
        }else{
            res[1] = "";
            res[0] = "valid";
        }
        return res;
    }
    static String[] signUpValidation(String name, String email, String phone, String password, String confirm){
        String res[] = new String[2];
        res[0] = "invalid";
        if(email.isEmpty() || password.isEmpty() || name.isEmpty() || phone.isEmpty() || confirm.isEmpty()){
            res[1] = "Please Input all the Fields";
        }else if(name.length() < 2 || name.length() > 20){
            res[1] = "Username's Length is only between 2 and 20 Characters";
        }else if(name.contains(" ")){
            res[1] = "Username must not contain any white space";
        } else if(SYMBOL.matcher(name).find()){
            res[1] = "Username must not contain any special character";
        } else if(email.length() > 40) {
            res[1] = "The length of the email must not exceed 40 characters";
        }else if(!VALID_EMAIL.matcher(email).matches()){
            res[1] = "The email is invalid";
        }else if(!(phone.length()<12 && phone.length()>8)){
            res[1] = "The phone number is invalid";
        }else if(phone.charAt(0) != '0'){
            res[1] = "Phone number must either start from 0 or + sign";
        } else if(password.length() < 6){
            res[1] = "The password must not less than 6 characters";
        }else if(!password.matches(".*\\d.*")){
            res[1] = "The password must contain at least one number";
        }else if(!SYMBOL.matcher(password).find()){
            res[1] = "The password must contain at least one special character";
        }else if(!confirm.equals(password)){
            res[1] = "The passwords are not matched";
        } else{
            res[1] = "";
            res[0] = "valid";
        }
        return res;
    }
}
