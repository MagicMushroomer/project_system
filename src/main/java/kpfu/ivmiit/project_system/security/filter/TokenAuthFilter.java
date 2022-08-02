package kpfu.ivmiit.project_system.security.filter;

import kpfu.ivmiit.project_system.security.token.TokenAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;

        String token = request.getParameter("token");

        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        if (token == null) {
            tokenAuthentication.setAuthenticated(false);
        } else {
            //передача знаний спрингу об аутентификации по токену, затем переход к провайдеру
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }


    @Override
    public void destroy() {

    }
}
