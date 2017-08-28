package chhatrachhorm.onenterpise.mvcdemo;

/**
 * Created by chhormchhatra on 8/28/17.
 */

public class StudentModel {
    private String password;
    private String userName;
    public StudentModel(){

    }
    public StudentModel(String password, String userName){
        this.password = password;
        this.userName = userName;
    }
    public String getPassword(){
        return password;
    }
    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
