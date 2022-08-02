package kpfu.ivmiit.project_system.dto;

import kpfu.ivmiit.project_system.model.Token;
import kpfu.ivmiit.project_system.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {
    private String token;
    private User user;

    public static TokenDto from(Token token, User user) {
        return new TokenDto(token.getToken(), user);
    }
}
