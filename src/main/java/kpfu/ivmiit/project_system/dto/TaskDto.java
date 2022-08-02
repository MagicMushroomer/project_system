package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.Sprint;
import kpfu.ivmiit.project_system.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
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
    private Long sprint;
    private Date dateOver;
    private List<User> worker;
    private Long project;
}
