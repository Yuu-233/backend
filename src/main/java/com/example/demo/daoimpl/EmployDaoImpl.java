package com.example.demo.daoimpl;

import com.example.demo.dao.EmployDao;
import com.example.demo.repository.EmployRepository;
import com.example.demo.utils.CompleteEmployInfo;
import com.example.demo.utils.CompleteResumeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployDaoImpl implements EmployDao {
    @Autowired
    private EmployRepository employRepository;

    @Override
    public void add_employ_info(Integer user_id,Integer rec_id){
        if(employRepository.checkHistory(user_id,rec_id) == null)
        employRepository.add_employ_info(user_id,rec_id);
    }
    @Override
    public void delete_employ_info(Integer user_id,Integer rec_id){
        employRepository.delete_employ_info(user_id,rec_id);
    }

    @Override
    public void update_employ_info(Integer user_id,Integer rec_id, Integer accepted ){
        employRepository.update_employ_info(user_id,rec_id,accepted);
    }

    @Override
    public List<CompleteResumeInfo> getMyEmployees(Integer rec_id){
        List<Object> list = employRepository.getMyEmployees(rec_id);
        System.out.println(list.size());
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
    public List<CompleteEmployInfo> getEmpbyId(Integer userid){
        List<Object> list = employRepository.getEmpbyId(userid);
        System.out.println(list.size());
        List<CompleteEmployInfo> list1 = new ArrayList<CompleteEmployInfo>();
        for(int i=0;i<list.size();i++){
            Object[] obj = (Object[])list.get(i); //obj中保存的是查询出的对象的属性值
            for(int j = 0 ; j < obj.length; j ++){ //循环打印Dept的属性值
                if(obj[j] == null) obj[j]="-1";
            }

            CompleteEmployInfo currinfo = new CompleteEmployInfo(Integer.parseInt(obj[0].toString()),obj[1].toString(),obj[2].toString(),obj[3].toString(),obj[4].toString(),obj[5].toString(),Integer.parseInt(obj[6].toString()),Integer.parseInt(obj[7].toString()),obj[8].toString(),obj[9].toString(),obj[10].toString(),Integer.parseInt(obj[12].toString()),Integer.parseInt(obj[13].toString()));
            list1.add(currinfo);
        }
        return list1;
        //return applyRepository.getAppbyId(userid);
    }

    @Override
    public List<CompleteEmployInfo> filt_employ_record(Integer userid,Integer identity,Integer accepted){
        if(identity == 0)
            return getEmpbyId(userid);
        else
            return getEmpbyId(userid);
    }
}
