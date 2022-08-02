package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String type;
    private Long worker;
}
