package com.moataz.first.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Task extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long tid;
 private String taskName;
 private String taskDescription;
 private int priority;
  @ManyToOne
 public User inCharge;
  @Column(columnDefinition = "VARCHAR(10) CHECK (status IN ('DONE', 'TO DO', 'DONE','TESTING','DEPLOYED'))")
 public String status;

}
