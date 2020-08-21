package com.example.demo.controller;

import com.example.demo.service.EmployService;
import com.example.demo.utils.CompleteEmployInfo;
import com.example.demo.utils.CompleteResumeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployController {

    @Autowired
    private EmployService employService;

    @CrossOrigin
    @RequestMapping("/add_employ_info")
    public void add_employ_info(@RequestParam("user_id")Integer user_id, @RequestParam("rec_id")Integer rec_id){
        employService.add_employ_info(user_id,rec_id);
    }

    @CrossOrigin
    @RequestMapping("/getMyEmployees")
    public List<CompleteResumeInfo> getMyEmployees(@RequestParam("rec_id")Integer rec_id){
        return employService.getMyEmployees(rec_id);
    }

    @CrossOrigin
    @RequestMapping("/getEmpbyId")
    public List<CompleteEmployInfo> getEmpbyId(@RequestParam("userid")Integer userid){return employService.getEmpbyId(userid);}

    @RequestMapping("/delete_employ_info")
    public void delete_apply_info(@RequestParam("user_id")Integer user_id,@RequestParam("rec_id")Integer rec_id){
        employService.delete_employ_info(user_id,rec_id);
    }
    @CrossOrigin
    @RequestMapping("/update_employ_info")
    public void update_apply_info(@RequestParam("user_id")Integer user_id,@RequestParam("rec_id")Integer rec_id, @RequestParam("accepted")Integer accepted){
        employService.update_employ_info(user_id,rec_id,accepted);
    }

    @CrossOrigin
    @RequestMapping("/filt_employ_record")
    public List<CompleteEmployInfo> filt_employ_record(@RequestParam("user_id")Integer user_id,@RequestParam("identity")Integer identity,@RequestParam("accepted")Integer accepted){
        return employService.filt_employ_record(user_id,identity,accepted);
    }

}
