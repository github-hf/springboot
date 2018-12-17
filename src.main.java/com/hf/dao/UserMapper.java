package com.hf.dao;
 
import java.util.List;
 
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
 
import com.hf.entity.User;
 

@Mapper
public interface UserMapper {
	
	@Select("select * from user")
	List<User> findAll();
 
	@Select("select * from user where id = #{id}")
	User findById(@Param("id") int id);
	
	@Insert("insert into user(name) values(#{name})")
	int insert(@Param("name") String name);
 
	@Update("update user set name=#{name} where id=#{id}")
	int update(User user);
 
	@Delete("delete from user where id=#{id}")
	int delete(int id);

	
	@Insert("insert into user(name) values(#{user.name})")
	int insert(User user);
	

	

	
}
