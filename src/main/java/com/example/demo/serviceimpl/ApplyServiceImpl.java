package com.example.demo.serviceimpl;

import com.example.demo.dao.ApplyDao;
import com.example.demo.service.ApplyService;
import com.example.demo.utils.CompleteApplyInfo;
import com.example.demo.utils.CompleteResumeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyDao applyDao;

    public void add_apply_info(Integer user_id,Integer rec_id){
        applyDao.add_apply_info(user_id,rec_id);
    }

    public List<CompleteApplyInfo> getAppbyId(Integer userid){return applyDao.getAppbyId(userid);}

    public List<CompleteResumeInfo> getMyApplicants(Integer rec_id){return applyDao.getMyApplicants(rec_id);}

    public void delete_apply_info(Integer user_id,Integer rec_id){
        applyDao.delete_apply_info(user_id,rec_id);
    }
    public void update_apply_info(Integer user_id,Integer rec_id, Integer accepted){
        applyDao.update_apply_info(user_id,rec_id, accepted);
    }

}
