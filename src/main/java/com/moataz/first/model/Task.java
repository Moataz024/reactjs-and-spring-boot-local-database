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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long tid;
 private String taskName;
 private String taskDescription;
  @Column(columnDefinition = "VARCHAR(10) CHECK (priority IN ('SEVERE', 'HIGH','MEDIUM','LOW'))")
 private String priority;
  @ManyToOne
 public User inCharge;
  @Column(columnDefinition = "VARCHAR(10) CHECK (status IN ('TODO', 'DONE','TESTING','DEPLOYED'))")
 public String status;

}
