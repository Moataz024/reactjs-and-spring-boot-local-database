package com.moataz.first.model;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
    @Column(columnDefinition = "VARCHAR(25) CHECK (role IN ('Project Manager', 'Employee')) default 'Employee'")
   private String role;
    @Column(columnDefinition = "VARCHAR(12)")
    private String phone;

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
