package com.example.demo.utils;

import com.example.demo.entity.Apply_Info;
import com.example.demo.entity.Recruit_Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompleteApplyInfo extends Object{
    private int Rec_ID;
    private String Rec_Salary;
    private String Rec_Location;
    private String Rec_TimeSchedule;
    private String Rec_Title;
    private String Rec_Cate;
    private Integer Rec_Enrolled;
    private Integer Rec_Quota;
    private String Rec_Desc;
    private String Rec_Experience;
    private String Rec_Education;
    private int User_ID;//应聘者userid
    private int accepted;


    public CompleteApplyInfo(int rec_ID, String rec_Salary,String rec_Location, String rec_TimeSchedule, String rec_Title, String rec_Cate, int rec_Enrolled, int rec_Quota, String rec_Desc, String rec_Experience, String rec_Education, int user_ID, int accepted) {

    this.Rec_ID=rec_ID;
    this.Rec_Salary=rec_Salary;
    this.Rec_Location=rec_Location;
    this.Rec_TimeSchedule=rec_TimeSchedule;
    this.Rec_Title=rec_Title;
    this.Rec_Cate=rec_Cate;
    this.Rec_Enrolled = rec_Enrolled;
    this.Rec_Quota=rec_Quota;
    this.Rec_Desc=rec_Desc;
    this.Rec_Experience=rec_Experience;
    this.Rec_Education=rec_Education;
    this.User_ID=user_ID;
    this.accepted=accepted;

    }

}
