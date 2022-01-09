import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.BootShiroVueStu;
import com.qxf.hiswww.dao.TCourseMapper;
import com.qxf.hiswww.dao.TRolePermsMapper;
import com.qxf.hiswww.domain.TCourse;
import com.qxf.hiswww.domain.TRolePerms;
import com.qxf.mapper.CourseMapper;
import com.qxf.mapper.RoleMapper;
import com.qxf.mapper.RolePermsMapper;
import com.qxf.pojo.Course;
import com.qxf.pojo.Role;
import com.qxf.pojo.RolePerms;
import com.qxf.service.RolePermsService;
import com.qxf.service.impl.CourseServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ Author 王炜雯
 * @ Date 2022/1/4  13:10
 */
@SpringBootTest(classes = {BootShiroVueStu.class})
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    TCourseMapper tcourseMapper;
    @Test
    public void Coursefind(){
        List<TCourse> tCourses = tcourseMapper.myWriteSelectByStratEndType("2019-11-12", "2019-11-30", "02");
        System.out.println(tCourses);
    }



}
