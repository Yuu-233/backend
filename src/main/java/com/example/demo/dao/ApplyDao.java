package com.example.demo.dao;

import com.example.demo.utils.CompleteApplyInfo;
import com.example.demo.utils.CompleteResumeInfo;

import java.util.List;

public interface ApplyDao {
    public void add_apply_info(Integer user_id,Integer rec_id);

    public List<CompleteApplyInfo> getAppbyId(Integer userid);
    public List<CompleteResumeInfo> getMyApplicants(Integer rec_id);

    public void delete_apply_info(Integer user_id,Integer rec_id);
    public void update_apply_info(Integer user_id,Integer rec_id, Integer accepted);

}
