package kpfu.ivmiit.project_system.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Date dateStart;
    private Date dateOver;
    @ManyToOne
    private Project project;

}
