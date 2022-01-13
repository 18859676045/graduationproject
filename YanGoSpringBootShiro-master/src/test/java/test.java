import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.BootShiroVueStu;
import com.qxf.hiswww.dao.TCourseMapper;
import com.qxf.hiswww.dao.TRolePermsMapper;
import com.qxf.hiswww.domain.TCourse;
import com.qxf.hiswww.domain.TRolePerms;
import com.qxf.mapper.CourseMapper;
import com.qxf.mapper.FastDfsMapper;
import com.qxf.mapper.RoleMapper;
import com.qxf.mapper.RolePermsMapper;
import com.qxf.pojo.*;
import com.qxf.service.FastDfsDelService;
import com.qxf.service.InstituteService;
import com.qxf.service.RolePermsService;
import com.qxf.service.SecretaryService;
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
    @Autowired
    FastDfsMapper fastDfsMapper;
    @Autowired
    InstituteService instituteService;
    @Autowired
    FastDfsDelService fastDfsDelService;
    @Autowired
    SecretaryService secretaryService;
    @Test
    public void Coursefind(){
        Page<FastDfsDel> fastDfsDelPage = new Page<>(1,2);
//        Page<Institute> institutePage = new Page<>(1,2);

        List<FastDfsDel> pic = fastDfsDelService.getFastDfsDelByPage(fastDfsDelPage, "个人");
//        List<Institute> pic = instituteService.getInstituteByPage(institutePage, "人工");
        System.out.println(pic);

    }
    @Test
    public void secretaryService(){
        Page<Secretary> secretaryPage = new Page<>(1,2);
//        Page<Institute> institutePage = new Page<>(1,2);
//        List<Institute> pic = instituteService.getInstituteByPage(institutePage, "人工");
        List<Secretary> jiaoxue = secretaryService.getSecretaryByPage(secretaryPage, "jiaoxue");
        System.out.println(jiaoxue);

    }



}
