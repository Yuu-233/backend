package com.example.demo.entity;
import com.example.demo.entity.CompositePK.App_CommentPK;
import com.example.demo.entity.CompositePK.Rec_CommentPK;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="app_comment")
public class App_Comment {
    @EmbeddedId
    private App_CommentPK app_commentPK;

    private String App_Comm;
    private Integer App_Grade;
}
