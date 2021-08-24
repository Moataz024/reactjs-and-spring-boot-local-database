package com.moataz.first.model;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "uid")
@Entity
public class User extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long uid;
   private String first_name;
   private String last_name;
    @Column( unique = true )
   private String email;
   private String password;

   @ManyToMany(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
   @Fetch(value= FetchMode.SELECT)
   @JoinTable(name = "user_projects",
            joinColumns = {
           @JoinColumn(name = "user_id")
            },
           inverseJoinColumns = {
           @JoinColumn(name = "project_id")
        }
   )
   private Set<Projects> projects = new HashSet<>();
   @OneToMany(mappedBy = "inCharge")
    List<Task> tasks = new ArrayList<>();

}
