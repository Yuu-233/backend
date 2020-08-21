package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompleteResumeInfo extends Object {
    private int User_ID;
    private int Rec_ID;
    private int accepted;
    private String Name;
    private String Gender;
    private String Birth;
    private String Experience;
    private String Education;

    public CompleteResumeInfo(int user_ID, int rec_ID, int accepted, String name, String gender, String birth, String experience, String education){
        this.User_ID = user_ID;
        this.Rec_ID = rec_ID;
        this.accepted = accepted;
        this.Name = name;
        this.Gender = gender;
        this.Birth=birth;
        this.Experience = experience;
        this.Education = education;
    }

    public CompleteResumeInfo(int parseInt, int parseInt1, int parseInt2) {
        this.User_ID = parseInt;
        this.Rec_ID = parseInt1;
        this.accepted = parseInt2;
    }
}
