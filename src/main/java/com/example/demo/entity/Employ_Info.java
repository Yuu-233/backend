package com.example.demo.entity;

import com.example.demo.entity.CompositePK.Employ_InfoPK;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Employ_Info")
public class Employ_Info {
    @EmbeddedId
    private Employ_InfoPK employ_infoPK;
    private Integer Accepted;
}
