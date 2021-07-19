package com.moataz.first.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "pid")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String p_name;
    private String Description;
     @Column(columnDefinition = "VARCHAR(10) CHECK (status IN ('ACTIVE', 'IN PROGRESS', 'INACTIVE'))")
    private String Status;
     @Column(columnDefinition = "integer(3) default 0")
     private int Completion;
     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "projects")
     @Fetch(value= FetchMode.SELECT)
     private Set<User> users = new HashSet<>();

}
