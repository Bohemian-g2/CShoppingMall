import com.github.pagehelper.Page;
import com.wsfzsc.mapper.CommentMapper;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.pojo.Comment;
import com.wsfzsc.pojo.CommentHelper;
import com.wsfzsc.service.AdminService;
import com.wsfzsc.service.CommentService;
import com.wsfzsc.util.CommentShow;
import com.wsfzsc.util.Encryption;
import com.wsfzsc.util.GUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentService commentService;

    @Test
    public  void testmain() {
        System.out.println(Encryption.Encrypt("wsfzsc"));//03D7E48DBAFD9E94
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

    @Test
    public void testdeleteAdmin(){
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(11);
        ids.add(10);
        System.out.println("删除数量===="+adminService.deleteAdmin(ids));
    }

    @Test
    public void testdeleteComment(){
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(4);
        System.out.println(commentService.deleteComment(ids));
    }
    @Test
    public void testQueryComment(){
        List<CommentShow> commentShowList=commentMapper.selectCommentByCID(1);
        System.out.println(commentShowList);
    }

    @Test
    public void testInsertComment(){
        Comment comment= new Comment(2020490055,3,"非常好，老子很喜欢");
        commentService.saveComment(comment);

    }

}
