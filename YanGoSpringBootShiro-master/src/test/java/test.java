import com.baomidou.mybatisplus.plugins.Page;
import com.qxf.BootShiroVueStu;
import com.qxf.hiswww.dao.TRolePermsMapper;
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
    RolePermsService rolePermsService;

    @Test
    public void  rolePerms(){
        List<RolePerms> list = rolePermsService.findRolesPermisByRole("1");
        String[] arr = new String[list.size()];
        for (int i = 0,j=list.size(); i < j; i++) {
            arr[i] = list.get(i).getPermsId();
            System.out.println(arr[i]);
        }
        System.out.println(1);

    }
    @Autowired
    RoleMapper roleMapper;
    @Test
    public void findRoleById(){
        Role byId = roleMapper.findById(1);
        System.out.println(byId);

    }
    @Autowired
    TRolePermsMapper rolePermsMapper;
    @Test
    public void findPermisByRoleId(){
        List<TRolePerms> tRolePerms = rolePermsMapper.selectByRoleId("2");
        System.out.println(tRolePerms);

    }
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseServiceImpl courseService;
    @Test
    public void Coursefind(){


    }



}
