package com.example.demo.entity;
import com.example.demo.entity.CompositePK.Rec_CommentPK;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="rec_comment")
public class Rec_Comment {
    @EmbeddedId
    private Rec_CommentPK rec_commentPK;

    private String Rec_Comm;
    private Integer Rec_Grade;
}
