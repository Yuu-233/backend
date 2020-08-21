package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="rec_gr")
public class Rec_Gr {
      @Id
      @Column(name="User_ID")
      private int User_ID;
      public int getUser_ID(){return User_ID;}
      public void setUser_ID(int user_id){this.User_ID=user_id;}

      private Float Rec_Avg_Grade;
      private Integer Rec_Grade_Num;

      @Basic
      @Column(name="Rec_Avg_Grade")
      public Float getRec_Avg_Grade(){return Rec_Avg_Grade;}
      public void setRec_Avg_Grade(Float rec_Avg_Grade){this.Rec_Avg_Grade=rec_Avg_Grade;}

      @Basic
      @Column(name="Rec_Grade_Num")
      public Integer getRec_Grade_Num(){return Rec_Grade_Num;}
      public void setRec_Grade_Num(Integer rec_Grade_Num){this.Rec_Grade_Num=rec_Grade_Num;}

}
