package com.hf.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hf.entity.User;
import com.hf.service.UserService;
 

 
/**
 * @Description:Controller层：调用Service层的代码实现数据的增删查改
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * @Description:查找所有用户
	 * 访问地址：http://localhost:8080/users/findAll
	 * @return
	 * @author:hf
	 */
	@RequestMapping("/findAll")
	public List<User> findAll() {
		System.out.println("查询所有");
		List<User> userList = userService.findAll();
		for(User user:userList) {
			System.out.println("用户："+user);
		}
		return userList;
	}
	
	/**
	 * @Description:根据用户ID查找用户
	 * 访问地址：http://localhost:8080/users/findById?id=2
	 * @param id
	 * @return
	 * @author:hf
	 */
	@RequestMapping("/findById")
	public User findById(@RequestParam("id") int id) {
		System.out.println("根据用户id查询用户");
		User user = userService.findById(id);
		System.out.println("用户:"+user);
		return user;
	}
	
	/**
	 * @Description:新增用户
	 * 访问地址：http://localhost:8080/users/insert?name=aaa
	 * @param name
	 * @return
	 * @author:hf
	 */
	@RequestMapping("/insert")
	public String insert(@RequestParam("name") String name) {
		System.out.println("新增用户");
		int result = userService.insert(name);
		if(result==1) {
			System.out.println("新增成功");
			return "success";
		}else {
			System.out.println("新增失败");
			return "error";
		}
	}
	/**
	 * @Description:根据用户ID修改用户
	 * 访问地址:http://localhost:8080/users/update?id=3&name=hf
	 * @param id
	 * @param name
	 * @return
	 * @author:hf
	 */
	@RequestMapping("/update")
	public String update(@RequestParam("id") int id,@RequestParam("name") String name) {
		System.out.println("修改用户");
		User user = new User();
		user.setId(id);
		user.setName(name);
		System.out.println(user);
		int result = userService.update(user);
		if(result==1) {
			System.out.println("修改成功");
			return "success";
		}else {
			System.out.println("修改失败");
			return "error";
		}
	}
	
	/**
	 * @Description:根据用户ID删除用户
	 * 访问地址：http://localhost:8080/users/delete?id=2
	 * @param id
	 * @return
	 * @author:hf
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		System.out.println("删除用户");
		int result = userService.delete(id);
		if(result==1) {
			System.out.println("删除成功");
			return "success";
		}else {
			System.out.println("删除失败");
			return "error";
		}
	}
	
}
