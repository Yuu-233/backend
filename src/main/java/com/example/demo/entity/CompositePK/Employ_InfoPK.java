package com.example.demo.entity.CompositePK;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Employ_InfoPK implements Serializable {
    private int User_ID;
    private int Rec_ID;
}
