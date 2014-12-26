package cn.edu.nju.sj12.model.user;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.edu.nju.sj12.beans.UserBean;
import cn.edu.nju.sj12.enums.Gender;
import cn.edu.nju.sj12.model.exceptions.FileNotOpenException;
import cn.edu.nju.sj12.model.helpers.XmlHelpr;

public class UserRegulationXmlImp implements UserRegulationInterface{
	private XmlHelpr helper;
	Document doc;
	Element root;
	
	public UserRegulationXmlImp(){
		helper = new XmlHelpr("UserInfo");
	}
	
	@Override
	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBean getUser(String id) {
		UserBean user = null;
		// TODO Auto-generated method stub
		try {
			String xpath = "/users/user[@id="+id+"]";
			Node node = helper.getNode(xpath);
			if(node==null){
				return null;
			}
			NodeList childList = node.getChildNodes();
			String name = childList.item(1).getTextContent();
			String password = childList.item(3).getTextContent();
			int age = Integer.parseInt(childList.item(5).getTextContent());
			Gender gender = (Gender)Enum.valueOf(Gender.class, childList.item(7).getTextContent());
			user = new UserBean(id);
			user.setPassword(password);
			user.setAge(age);
			user.setGender(gender);
			user.setName(name);
		} catch (FileNotOpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

}
