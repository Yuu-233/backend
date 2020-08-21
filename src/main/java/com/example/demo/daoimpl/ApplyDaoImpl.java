package com.example.demo.daoimpl;

import com.example.demo.dao.ApplyDao;
import com.example.demo.entity.Apply_Info;
import com.example.demo.entity.Recruit_Info;
import com.example.demo.repository.ApplyRepository;
import com.example.demo.service.ApplyService;
import com.example.demo.utils.CompleteApplyInfo;
import com.example.demo.utils.CompleteResumeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

@Repository
public class ApplyDaoImpl implements ApplyDao {
    @Autowired
    private ApplyRepository applyRepository;

    @Override
    public void add_apply_info(Integer user_id,Integer rec_id){
        if (applyRepository.checkHistory(user_id,rec_id) == null)
        applyRepository.add_apply_info(user_id,rec_id);
    }


    @Override
    public List<CompleteApplyInfo> getAppbyId(Integer userid){
        List<Object> list = applyRepository.getAppbyId(userid);
        System.out.println(list.size());
        List<CompleteApplyInfo> list1 = new ArrayList<CompleteApplyInfo>();
      for(int i=0;i<list.size();i++){
              Object[] obj = (Object[])list.get(i); //obj中保存的是查询出的对象的属性值
              for(int j = 0 ; j < obj.length; j ++){ //循环打印Dept的属性值
                  if(obj[j] == null) obj[j]="-1";
              }

            CompleteApplyInfo currinfo = new CompleteApplyInfo(Integer.parseInt(obj[0].toString()),obj[1].toString(),obj[2].toString(),obj[3].toString(),obj[4].toString(),obj[5].toString(),Integer.parseInt(obj[6].toString()),Integer.parseInt(obj[7].toString()),obj[8].toString(),obj[9].toString(),obj[10].toString(),Integer.parseInt(obj[12].toString()),Integer.parseInt(obj[13].toString()));
             list1.add(currinfo);
        }
             return list1;
        //return applyRepository.getAppbyId(userid);
    }

    @Override
    public List<CompleteResumeInfo> getMyApplicants(Integer rec_id){
        List<Object> list = applyRepository.getMyApplicants(rec_id);
        List <CompleteResumeInfo> list1 = new ArrayList<CompleteResumeInfo>();
        for(int i=0;i<list.size();i++){
            Object[] obj = (Object[])list.get(i); //obj中保存的是查询出的对象的属性值
            for(int j = 0 ; j < obj.length; j ++){ //循环打印Dept的属性值
                if(obj[j] == null) obj[j]="-1";
            }

            CompleteResumeInfo currInfo = new CompleteResumeInfo(Integer.parseInt(obj[0].toString()),Integer.parseInt(obj[1].toString()),Integer.parseInt(obj[2].toString()),obj[3].toString(),obj[4].toString(),obj[5].toString(),obj[6].toString(),obj[7].toString());
            list1.add(currInfo);
        }

        return list1;
        //return applyRepository.getMyApplicants(userid);
    }


    @Override
    public void delete_apply_info(Integer user_id,Integer rec_id){
        applyRepository.delete_apply_info(user_id,rec_id);
    }

    @Override
    public void update_apply_info(Integer user_id,Integer rec_id, Integer accepted ){
        applyRepository.update_apply_info(user_id,rec_id,accepted);
    }

}
