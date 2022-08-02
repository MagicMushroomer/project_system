package kpfu.ivmiit.project_system.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String techDescription;
    private String status;
    @OneToMany
    private List<UserHistory> userHistory;
    @ManyToOne
    private Project project;
}
