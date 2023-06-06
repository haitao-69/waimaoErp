package cn.edu.bcu.demo.resources;

import cn.edu.bcu.demo.domain.User;
import cn.edu.bcu.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping(value="/api/v1")
public class UserResources {
    private final UserService userService;

    @Autowired
    public UserResources(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<HashMap<String, Object>> showRegisterView(User User) {
        HashMap<String,Object> resultMap = new HashMap();
        ResponseEntity<HashMap<String,Object>> resultEntity = null;
        try {
            int result = this.userService.register(User);
            if(result>0) {
                resultMap.put("code", 1000);
                resultMap.put("msg", "注册成功");
            }else if(result == 0) {
                resultMap.put("code", 1001);
                resultMap.put("msg", "注册失败，参数解析出现问题");
            }
            resultEntity = new ResponseEntity<>(resultMap, HttpStatus.OK);
        }catch(Exception ex) {
            resultMap.put("msg", "注册失败，服务器程序出现错误");
            resultEntity = new ResponseEntity<>(resultMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            return resultEntity;
        }
    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, Object>> login(User User) {
        HashMap<String,Object> resultMap = new HashMap();
        ResponseEntity<HashMap<String,Object>> resultEntity = null;
        try {
            int result = this.userService.login(User);
            if(result>0) {
                resultMap.put("code", 1000);
                resultMap.put("msg", "登录成功");
            }else if(result == 0) {
                resultMap.put("code", 1002);
                resultMap.put("msg", "登录失败，用户名或密码输入错误");
            }
            resultEntity = new ResponseEntity<>(resultMap,HttpStatus.OK);
        }catch(Exception ex) {
            resultMap.put("msg", "登录失败，服务器程序出现错误");
            resultEntity = new ResponseEntity<>(resultMap,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            return resultEntity;
        }
    }


}
