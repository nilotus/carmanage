package jit.manage.controller;

import jit.manage.Dto.PsDto;
import jit.manage.Dto.UserDto;
import jit.manage.pojo.User;
import jit.manage.service.UserService;
import jit.manage.util.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by sunlotus on 2019/2/21.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public MSG addUser(@RequestBody User user){
        return  userService.addUser(user);
    }

    @PostMapping("/login")
    public MSG login(@RequestParam String name, @RequestParam String pw) throws IOException {
        //System.out.println("--------------------id: "+name+" pw: "+pw);
        return userService.login(name,pw);
    }

    @PostMapping("/isexisted")
    public MSG isexisted(@RequestParam("id") String id){
        return userService.findOne(id);
    }

    @PostMapping("/delete/{id}")
    public MSG delete(@PathVariable("id") String id){
        return userService.delete(id);
    }

    @PostMapping("/userInfo/{id}")
    public MSG userInfo(@PathVariable("id") String id){
        return  userService.userInfo(id);
    }

    @PostMapping("/selectAll")
    public String users(int page,int limit){
        return userService.users(page,limit);
    }

    @PostMapping("/upload")
    public MSG upload(@RequestParam("id") String id,@RequestParam("file") MultipartFile image) throws IOException {
        return userService.upload(id,image);
    }

    @PostMapping("/updateps")
    public MSG updateps(@RequestBody PsDto dto){
        System.out.println("-----------------"+dto.toString());
        return userService.updateps(dto);
    }

    @PostMapping("/updateuid/{id}")
    public MSG updateuid(@PathVariable("id") String id){
        return userService.updateuid(id);
    }

    @PostMapping("/update")
    public MSG update(@RequestBody UserDto dto){
        return userService.update(dto);
    }
}
