package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SprintDto {
    private Long id;
    private String name;
    private Date dateStart;
    private Date dateOver;
    private Long project;
}
