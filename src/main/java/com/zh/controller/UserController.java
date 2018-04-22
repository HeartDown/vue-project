package com.zh.controller;

import com.xiaoleilu.hutool.json.JSONUtil;
import com.zh.repository.UserRepository;
import com.zh.domain.User;
import com.zh.util.ResultMessage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangheng on 2017/12/11.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = this.userRepository.findOne(id);
        findOne.setPassword("");
        return findOne;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello word";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMessage login(@RequestParam String data) {
        ResultMessage resultMessage;
        User user = JSONUtil.toBean(data, User.class);
        String username = user.getUsername();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            resultMessage = ResultMessage.getSuccessResult("验证通过");
        } catch (UnknownAccountException uae) {
            resultMessage = ResultMessage.getFailResult("未知账户","验证未通过");
        } catch (IncorrectCredentialsException ice) {
            resultMessage = ResultMessage.getFailResult("错误的用户名或密码","验证未通过");
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
        } catch (LockedAccountException lae) {
            resultMessage = ResultMessage.getFailResult("账户已锁定","验证未通过");
        } catch (ExcessiveAttemptsException eae) {
            resultMessage = ResultMessage.getFailResult("错误次数过多","验证未通过");
        } catch (AuthenticationException ae) {
            resultMessage = ResultMessage.getFailResult("。。。","验证未通过");
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            return resultMessage;
        } else {
            token.clear();
            return resultMessage;
        }
    }

    @GetMapping("/login")
    @ResponseBody
    public ResultMessage login() {
        ResultMessage resultMessage = ResultMessage.getFailResult("未登录", "失败");
        return resultMessage;
    }

    @PostMapping("/register")
    public ResultMessage register(HttpServletRequest request){
        String jsonData = request.getParameter("data");
        ResultMessage resultMessage;
        if (!StringUtils.isEmpty(jsonData)){
            User user = JSONUtil.toBean(jsonData,User.class);
            userRepository.save(user);
            resultMessage = ResultMessage.getSuccessResult("注册成功");
        }
        else {
            resultMessage = ResultMessage.getFailResult("注册失败", "数据格式不正确");
        }
        return resultMessage;
    }
}
