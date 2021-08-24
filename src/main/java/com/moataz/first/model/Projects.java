package com.moataz.first.model;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "pid")
@Entity
public class Projects extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String p_name;
    private String Description;
     @Column(columnDefinition = "VARCHAR(10) CHECK (status IN ('ACTIVE', 'IN PROGRESS', 'INACTIVE'))")
    private String Status;
     @Column(columnDefinition = "integer(3) default 0")
     private int Completion;
     @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "projects")
     @Fetch(value= FetchMode.SELECT)
     private Set<User> users = new HashSet<>();

}
