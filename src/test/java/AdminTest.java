import com.wsfzsc.pojo.Admin;
import com.wsfzsc.service.AdminService;
import com.wsfzsc.util.Encryption;
import com.wsfzsc.util.GUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminTest {
    @Autowired
    private AdminService adminService;

    @Test
    public  void testmain() {
        System.out.println(Encryption.Encrypt("123123"));
    }

    @Test
    public void testUid(){
        List<String> tests=new ArrayList<>();
        tests.add("asd");
        System.out.println(tests.contains("asd"));
    }
    @Test
    public void testSaveAdmin(){
        String s="啊飒飒的a";
        System.out.println(s+" of length is "+s.length());
    }
}
