package com.example.demo.controller;

import com.example.demo.config.StudentConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/stu")
@Slf4j
public class StudentController {

    @Autowired
    private StudentConfig studentConfig;

    @GetMapping("/getStuConfig")
    public Object getStuConfig() {
        return studentConfig;
    }

    @Value("${student.address.detailName}")
    private String detailName;

    @Value("${student.address.port}")
    private String port;

    @GetMapping("/getDetailName")
    public String getDetailName() {
        return detailName + ";" + port;
    }

    @GetMapping("{stuId}/get")
    public String getStu(@PathVariable("stuId") String stuId,
                         @RequestParam Integer id,
                         @RequestParam String name){
        log.info("stuId="+ stuId);
        log.info("id=" + id);
        log.info("name=" + name);
        return "查询stu";
    }

    @PostMapping("/createStu")
    public String createStu(@RequestBody Map<String,Object> map,
                            @RequestHeader("token") String token,
                            @CookieValue("clientId") String clientId,
                            HttpServletRequest httpServletRequest){
        log.info("token:" + token);
        log.info("clientId" + clientId);
        log.info(map.toString());
        String headerToken = httpServletRequest.getHeader("token");
        log.info("headerToken:"+headerToken);
        return "新增stu";
    }

    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws Exception{
        file.transferTo(new File("/Users/starcantfly/Downloads/test/" + file.getOriginalFilename()));
//        file.transferTo(new File("http://172.22.114.176/test/" + file.getOriginalFilename()));
        return "上传成功!";
    }

}
