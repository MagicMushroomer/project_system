package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackerDto {
    private Long id;
    private String name;
    private String status;
    private Long task;
}
