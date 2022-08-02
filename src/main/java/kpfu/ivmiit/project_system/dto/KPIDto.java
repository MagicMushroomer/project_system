package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.KGI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPIDto {
    private Long id;
    private String description;
    private Long kgi;
}
