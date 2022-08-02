package kpfu.ivmiit.project_system.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private boolean isPublic;
    private String git;
    private Long worker;
}
