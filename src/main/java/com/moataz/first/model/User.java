package com.moataz.first.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "uid")
public class User {

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

}
