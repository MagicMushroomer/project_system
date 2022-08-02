package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.UserHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BacklogDto {
    private Long id;
    private String name;
    private String techDescription;
    private String status;
    private List<UserHistory> userHistory;
    private Long project;
}
