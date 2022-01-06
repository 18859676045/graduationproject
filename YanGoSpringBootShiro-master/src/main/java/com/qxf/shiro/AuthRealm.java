package com.qxf.shiro;

import com.qxf.hiswww.dao.*;
import com.qxf.hiswww.domain.*;
import com.qxf.pojo.User;
import com.qxf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;




public class AuthRealm extends AuthorizingRealm {

    /**
     * 日志打印
     */
    private final static Logger log = LoggerFactory.getLogger(AuthRealm.class);

    /**
     * 用户
     */
    @Autowired
    private UserService userService;

    @Autowired
    private TPermsMapper permissionMapper;
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TUserRoleMapper tUserRoleMapper;
    @Autowired
    private TRoleMapper roleMapper;
    //权限角色表
    @Autowired
    private TRolePermsMapper rolePermsMapper;

    //授权
    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        System.out.println("--------------授权了------------------");

        Object obj=principals.getPrimaryPrincipal();//获取用户的账号，根据账号来从数据库中获取数据
        //定义用户角色的set集合这个集合应该来自数据库
        //注意：由于每次点击需要授权的请求时，Shiro都会执行这个方法，因此如果这里的数据时来自于数据库中的
        //     那么一定要控制好不能每次都从数据库中获取数据这样效率太低了

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();


        //根据名称查询用户
        TUserExample tUserExample = new TUserExample();
        tUserExample.or().andUsernameEqualTo(obj.toString());
        TUser tUser = tUserMapper.selectOneByExample(tUserExample);

        // 根据用户id查询用户角色
        //用户，角色表
        TUserRoleExample tUserRoleExample = new TUserRoleExample();
        tUserRoleExample.or().andUserIdEqualTo(tUser.getId());
        List<TUserRole> tUserRoles = tUserRoleMapper.selectByExample(tUserRoleExample);

        for (int i = 0, roleLen = tUserRoles.size(); i < roleLen; i++) {
            TUserRole tUserRole = tUserRoles.get(i);
            // 添加角色
            simpleAuthorizationInfo.addRole(roleMapper.selectByPrimaryKey(tUserRole.getRoleId()).getName());
            // 根据角色的id，在权限角色表中查询权限
            List<TRolePerms> tRolePerms = rolePermsMapper.selectByRoleId(tUserRole.getRoleId());
            for (int j = 0, perLen = tRolePerms.size(); j < perLen; j++) {
                TRolePerms tRolePerms1 = tRolePerms.get(j);
                // 添加权限
                simpleAuthorizationInfo.addStringPermission(permissionMapper.selectByPrimaryKey(tRolePerms1.getPermsId()).getUrl());
            }
        }

        return simpleAuthorizationInfo;
    }

    /**
     * @desc: 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("======================= 认证登陆 ======================");
        // 获取用户输入的token
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String name = upToken.getUsername();
        String pass = String.valueOf(upToken.getPassword());
        User u = new User();
        u.setUsername(name);
        u.setPassword(pass);
        List<User> list = userService.checkUser(u);
        User userInfoDto = null;
        if (null == list || list.isEmpty()) {
            throw new AuthenticationException("账号或密码错误");
        } else if (list.get(0).getEnable() == 0) {
            /**
             * 账号被禁用
             */
            throw new AuthenticationException("账号已被禁止登陆,请联系管理员");
        }else{
            userInfoDto = list.get(0);
            //登录成功
            userInfoDto.setLastLoginTime(new Date());
//            Subject subject = SecurityUtils.getSubject();
//            Session session = subject.getSession();
//            session.setAttribute("loginUser",userInfoDto);

        }
        log.info("======================= 登陆成功 ======================");
        return new SimpleAuthenticationInfo(userInfoDto, userInfoDto.getPassword(), getName());
    }
}
