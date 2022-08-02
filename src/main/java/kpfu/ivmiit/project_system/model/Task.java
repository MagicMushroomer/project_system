package kpfu.ivmiit.project_system.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String theme;
    private String priority;
    private String status;
    private String description;
    private int timeSpent;
    private int maxTime;
    private int bug;
    private int strings;
    @ManyToOne
    private Sprint sprint;
    private Date dateOver;
    @ManyToMany
    private List<User> worker;
    @ManyToOne
    private Project project;
}
