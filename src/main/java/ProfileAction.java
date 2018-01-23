import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ProfileAction{
	
	//getters and setters   
	
	private Profile pro;
	public Profile getPro() {
		return pro;
	}
	public void setPro(Profile pro) {
		this.pro = pro;
	}

	 
	public String update(){
		if (UserDao.saveOrUpdat(pro)){
            return "success";
        } else {
            return "error";
        }
	}
	public String profile(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("login") != null){
		List<Profile> list = UserDao.check(session.getAttribute("id").toString());
		if (list.size() > 0){
			System.out.println(list.get(0).getUserId());
			pro =  new Profile();
			pro.setUserId(list.get(0).getUserId());
			pro.setDob(list.get(0).getDob());
			pro.setAddress(list.get(0).getAddress());
			pro.setCity(list.get(0).getCity());
			pro.setState(list.get(0).getState());
			pro.setFname(list.get(0).getFname());
			pro.setLname(list.get(0).getLname());
			pro.setGender(list.get(0).getGender());
			pro.setMobile(list.get(0).getMobile());
            return "success";
        } else {
            return "error";
        }}
		else{
			return "input";
		}
	}
	

}
