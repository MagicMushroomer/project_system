package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Task;
import kpfu.ivmiit.project_system.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserKPIDto {
    private Long id;
    private User user;
    private Task task;
    private double value;
}
