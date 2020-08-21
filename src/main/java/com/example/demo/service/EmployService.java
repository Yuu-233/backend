package com.example.demo.service;

import com.example.demo.utils.CompleteEmployInfo;
import com.example.demo.utils.CompleteResumeInfo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EmployService {

    public void add_employ_info(Integer user_id,Integer rec_id);
    public void delete_employ_info(Integer user_id,Integer rec_id);
    public void update_employ_info(Integer user_id,Integer rec_id, Integer accepted);
    public List<CompleteResumeInfo> getMyEmployees(Integer rec_id);
    public List<CompleteEmployInfo> getEmpbyId(Integer userid);
    public List<CompleteEmployInfo> filt_employ_record(Integer userid, Integer identity,Integer accepted);
}
