package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="app_gr")
public class App_Gr {
    @Id
    @Column(name="User_ID")
    private Integer User_ID;
    public Integer getUser_ID(){return User_ID;}
    public void setUser_ID(Integer user_id){this.User_ID=user_id;}

    private Float App_Avg_Grade;
    private Integer App_Grade_Num;

    @Basic
    @Column(name="App_Avg_Grade")
    public Float getApp_Avg_Grade(){return App_Avg_Grade;}
    public void setApp_Avg_Grade(Float app_Avg_Grade){this.App_Avg_Grade=app_Avg_Grade;}

    @Basic
    @Column(name="App_Grade_Num")
    public Integer getApp_Grade_Num(){return App_Grade_Num;}
    public void setApp_Grade_Num(Integer app_Grade_Num){this.App_Grade_Num=app_Grade_Num;}

}
