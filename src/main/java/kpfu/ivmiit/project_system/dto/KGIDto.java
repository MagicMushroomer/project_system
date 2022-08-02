package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KGIDto {
    private Long id;
    private String description;
    private Long project;
}
