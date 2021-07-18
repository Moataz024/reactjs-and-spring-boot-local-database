package com.moataz.first.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
@Entity
public class Task {

  @Id
 private Long tid;
 private String taskName;
 private String taskDescription;
 private int priority;
  @ManyToOne
 public User inCharge;
  @Column(columnDefinition = "VARCHAR(10) CHECK (status IN ('DONE', 'TO DO', 'DONE','TESTING','DEPLOYED'))")
 public String status;

}
