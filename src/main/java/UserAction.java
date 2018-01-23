
/*public class UserAction {
	private String userName;
	private String passWord;
	private String email;
	
	private LoginBean loginBean;
	
	public void loginUser() {
		//Username & pass
		User u = new User();
		u.setUser(userName);
		u.setPassword(passWord);
		
		UserDao.login(u);
	}
	
	public void registerUser() {
		//Username, email, pass
	}
}*/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware{ 
	private SessionMap<String,Object> sessionMap;  
	private User login;
	public User getLogin() {
		return login;
	}
	public void setLogin(User login) {
		this.login = login;
	}

	//getters and setters   
	
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	}
	public SessionMap<String,Object> getSession(){
		return sessionMap;
	}
	
	public String validate(){
		if (UserDao.find(login)) {
			 sessionMap.put("login","true");
			 sessionMap.put("id", login.getUserId());
			 sessionMap.put("name",login.getUser());  
            return "success";
        } else {
            return "error";
        }
	}
	public String register(){
		login.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		login.setStatus(1);
		if (UserDao.saveUser(login)){
            return "success";
        } else {
            return "error";
        }
	}

	public String logout(){  
	    if(sessionMap != null){  
	        sessionMap.invalidate();  
	    }  
	    return "success";  
	}  
	

}

