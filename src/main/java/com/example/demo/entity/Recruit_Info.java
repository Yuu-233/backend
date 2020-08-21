package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="recruit_info")
public class Recruit_Info {
        @Id
        @Column(name="Rec_ID")
        @GeneratedValue(strategy=GenerationType.AUTO)
        private int Rec_ID;
        public int getRec_ID(){return Rec_ID;}
        public void setRec_ID(int rec_ID){this.Rec_ID=rec_ID;}


        private Integer User_ID;
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
        private String Tags;
        public Recruit_Info(){}


         public Recruit_Info(Integer user_ID,String rec_Salary,String rec_Location,String rec_TimeSchedule,String rec_Title,
                            String rec_Cate,Integer rec_Enrolled,Integer rec_Quota,String rec_Desc,String rec_Experience,String rec_Education){
                this.User_ID = user_ID;
                this.Rec_Salary = rec_Salary;
                this.Rec_Location = rec_Location;
                this.Rec_TimeSchedule = rec_TimeSchedule;
                this.Rec_Title = rec_Title;
                this.Rec_Cate=rec_Cate;
                this.Rec_Enrolled=rec_Enrolled;
                this.Rec_Quota=rec_Quota;
                this.Rec_Desc = rec_Desc;
                this.Rec_Experience=rec_Experience;
                this.Rec_Education = rec_Education;
        }


        public Recruit_Info(Integer rec_ID,Integer user_ID,String rec_Salary,String rec_Location,String rec_TimeSchedule,String rec_Title,
                            String rec_Cate,Integer rec_Enrolled,Integer rec_Quota,String rec_Desc,String rec_Experience,String rec_Education){
                this.Rec_ID = rec_ID;
                this.User_ID = user_ID;
                this.Rec_Salary = rec_Salary;
                this.Rec_Location = rec_Location;
                this.Rec_TimeSchedule = rec_TimeSchedule;
                this.Rec_Title = rec_Title;
                this.Rec_Cate=rec_Cate;
                this.Rec_Enrolled=rec_Enrolled;
                this.Rec_Quota=rec_Quota;
                this.Rec_Desc = rec_Desc;
                this.Rec_Experience=rec_Experience;
                this.Rec_Education = rec_Education;
        }

        @Basic
        @Column(name="User_ID")
        public Integer getUser_ID(){return User_ID;}
        public void setUser_ID(Integer user_ID){this.User_ID=user_ID;}

        @Basic
        @Column(name="Rec_salary")
        public String getRec_salary(){return Rec_Salary;}
        public void setRec_salary(String rec_Salary){this.Rec_Salary = rec_Salary;}

        @Basic
        @Column(name="Rec_Location")
        public String getRec_Location(){return Rec_Location;}
        public void setRec_Location(String rec_Location){this.Rec_Location=rec_Location;}

        @Basic
        @Column(name="Rec_TimeSchedule")
        public String getRec_TimeSchedule(){return Rec_TimeSchedule;}
        public void setRec_TimeSchedule(String rec_TimeSchedule){this.Rec_TimeSchedule=rec_TimeSchedule;}

        @Basic
        @Column(name="Rec_Title")
        public String getRec_Title(){return Rec_Title;}
        public void setRec_Title(String rec_Title){this.Rec_Title = rec_Title;}

        @Basic
        @Column(name="Rec_Cate")
        public String getRec_Cate(){return Rec_Cate;}
        public void setRec_Cate(String rec_Cate){this.Rec_Cate = rec_Cate;}

        @Basic
        @Column(name="Rec_Enrolled")
        public Integer getRec_Enrolled(){return Rec_Enrolled;}
        public void setRec_Enrolled(Integer rec_Enrolled){this.Rec_Enrolled=rec_Enrolled;}

        @Basic
        @Column(name="Rec_Quota")
        public Integer getRec_Quota(){return Rec_Quota;}
        public void setRec_Quota(Integer rec_Quota){this.Rec_Quota = rec_Quota;}

        @Basic
        @Column(name="Rec_Desc")
        public String getRec_Desc(){return Rec_Desc;}
        public void setRec_Desc(String rec_Desc){this.Rec_Desc = rec_Desc;}

        @Basic
        @Column(name="Rec_Experience")
        public String getRec_Experience(){return Rec_Experience;}
        public void setRec_Experience(String rec_Experience){this.Rec_Experience = rec_Experience;}

        @Basic
        @Column(name="Rec_Education")
        public String getRec_Education(){return Rec_Education;}
        public void setRec_Education(String rec_Education){this.Rec_Education = rec_Education;}
}
