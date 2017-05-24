package login;

import java.io.Serializable;

public class LoginUserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id_;
    private String pass;
    private String name_;
    private int age_;

    public LoginUserBean() {
        id_ = "";
        name_ = "";
        age_ = 0;
        pass = "";
    }

    public LoginUserBean(String id, String name, int age, String pass) {
        id_ = id;
        name_ = name;
        age_ = age;
        this.pass = pass;
    }

    public void setId(String id){
        id_ = id;
    }

    public String getId(){
        return id_;
    }

    public void setName(String name){
        name_ = name;
    }

    public String getName(){
        return name_;
    }

    public void setAge(int age){
        age_ = age;
    }

    public int getAge(){
        return age_;
    }

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

}