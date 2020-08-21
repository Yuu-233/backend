package com.example.demo.serviceimpl;

import com.example.demo.dao.EmployDao;
import com.example.demo.service.EmployService;
import com.example.demo.utils.CompleteEmployInfo;
import com.example.demo.utils.CompleteResumeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployServiceImpl implements EmployService {
    @Autowired
    EmployDao employDao;

    public void add_employ_info(Integer user_id,Integer rec_id){
        employDao.add_employ_info(user_id,rec_id);
    }

    public void delete_employ_info(Integer user_id,Integer rec_id){
        employDao.delete_employ_info(user_id,rec_id);
    }
    public void update_employ_info(Integer user_id,Integer rec_id, Integer accepted){
        employDao.update_employ_info(user_id,rec_id, accepted);
    }
    public List<CompleteResumeInfo> getMyEmployees(Integer rec_id){return employDao.getMyEmployees(rec_id);}
    public List<CompleteEmployInfo> getEmpbyId(Integer userid){return employDao.getEmpbyId(userid);}
    public List<CompleteEmployInfo> filt_employ_record(Integer userid,Integer identity,Integer accepted){
        return employDao.filt_employ_record(userid,identity,accepted);
    }
}
