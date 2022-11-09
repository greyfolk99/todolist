package com.greyfolk99.todolist.model.entity;

import com.greyfolk99.todolist.model.request.UpdateContentRequest;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Content extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;
    @Column(nullable = true)
    private Integer orderNo;
    @Column(nullable = true)
    private String context;

    @Column(name = "to_do_id")
    private Long toDoId;
    @ManyToOne
    @JoinColumn(name = "to_do_id", insertable = false, updatable = false)
    @ToString.Exclude
    private ToDo toDo;


    @Builder
    public Content(Long contentId, Integer orderNo, String context, ToDo toDo, Long toDoId) {
        this.contentId = contentId;
        this.orderNo = orderNo;
        this.context = context;
        this.toDo = toDo;
        this.toDoId = toDoId;
    }
    public void updateAll(UpdateContentRequest request){
        this.orderNo = request.getOrderNo();
        this.context = request.getContext();
    }
}