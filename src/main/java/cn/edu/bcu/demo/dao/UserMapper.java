package cn.edu.bcu.demo.dao;

//import cn.edu.bcu.demo.domain.TAdmin;
import cn.edu.bcu.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Insert("insert into t_user(user_name,psw,phone,address) "
			+ "values(#{user_name},#{psw},#{phone},#{address})")
	public int insert(User User);

//	@Insert("insert into t_admin(admin_name,password,phone) "
//			+ "values(#{admin_name},#{password},#{phone})")
//	public int insertAdmin(Admin tAdmin);
	
	@Select("select count(*)from t_user where user_name=#{user_name} and psw=#{psw}")
	public int selectOne(User User);

//	@Select("select count(*)from t_admin where admin_name=#{admin_name} and password=#{password}")
//	int selectAdminOne(Admin tAdmin);

	@Select("select * from t_user where user_name=#{userName}")
	User selectUserName(String userName);
}
