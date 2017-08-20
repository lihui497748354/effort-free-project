package com.effort.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.effort.domain.User;
import com.effort.service.IUserService;

@RestController
public class UserController {
	
	
	Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	
	@GetMapping("/selectUser")
	public List<User> selectUser(){
		return userService.selectUser();
	}
	
	@GetMapping("/deleteUser")
	public int deleteUser(String ids){
		return userService.deleteUser(ids);
	}
	
	@PostMapping("/saveUser")
	public User saveUser(User user){
		return userService.saveUser(user);
	}
	
	@PostMapping("/getJson")
	public String getJson(@RequestBody String url){
		
		User user = new User();
		user.setUId(url);
		user.setUName("Effort");
		user.setUage(27);
		JSONObject jsonObj = new JSONObject(user);
		logger.info(jsonObj);
		return jsonObj.toString().trim();
	}
	
	
	private static Map iterateElement(Element element){
		List nodeList = element.getChildren();
		Element et = null;
		Map obj = new HashMap();
		List lister = null;
		for(int i=0;i<nodeList.size();i++){
			lister = new LinkedList();
			et = (Element) nodeList.get(i);
			if(et.getTextTrim().equals("")){
				if(et.getChildren().size() == 0){
					obj.put(et.getName(), et.getValue());
				}
				if(obj.containsKey(et.getName())){
					lister = (List) obj.get(et.getName());
				}
				lister.add(iterateElement(et));
				obj.put(et.getName(), lister);
			}else{
				if(obj.containsKey(et.getName())){
					lister = (List) obj.get(et.getName());
				}
				/*
				list 添加 会出现内容一只为jsonArray的情况
				 */
				//lister.add(et.getTextTrim());
				obj.put(et.getName(), et.getTextTrim());
			}
		}
		return obj;
	}
	
	@PostMapping("/xmltojson")
	private static String xml2Json(@RequestBody String xml) throws JDOMException, IOException{
		JSONObject jsonObject = new JSONObject();
		InputStream inputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		SAXBuilder saxBuilder = new SAXBuilder();
		Document doc = saxBuilder.build(inputStream);
		Element root = doc.getRootElement();
		jsonObject.put(root.getName(), iterateElement(root));
		return jsonObject.toString();
	}
}
