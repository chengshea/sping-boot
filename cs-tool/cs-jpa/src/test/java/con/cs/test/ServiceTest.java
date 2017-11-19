package con.cs.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.App;
import com.cs.model.CsUser;
import com.cs.service.UserService;

@SpringBootTest(classes=App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {
	

	@Autowired
	private UserService us;
	
	
	@Test
	public void test(){
		CsUser  user = new CsUser();
		user.setEmail("cs@qq.com");
		user.setCreateDate(new Date());
		user.setNickname("nick");
		user.setPwd("cdsd");
		user.setStatus(1);
		user.setLastLoginTime(new Date());
		Object save = us.save(user);
		System.out.println(save);
	}

}
