package com.example.demo.entity;
import com.example.demo.entity.CompositePK.Apply_InfoPK;
import com.example.demo.entity.CompositePK.Rec_CommentPK;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="apply_info")
public class Apply_Info {
    @EmbeddedId
    private Apply_InfoPK apply_infoPK;
    private Integer Accepted;
}
