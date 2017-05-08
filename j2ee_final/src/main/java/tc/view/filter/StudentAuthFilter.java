package tc.view.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by stonezhang on 2016/12/30.
 */
public class StudentAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.startsWith("/student/login") || path.startsWith("/student/register")) {
            filterChain.doFilter(servletRequest, servletResponse); // Just continue chain.
        }
        else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
//        if((session != null) && (session.getAttribute("isLogin") == null)) {
            if (session == null || session.getAttribute("studentInfoVO") == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("/student/login");
                return;
            }

            filterChain.doFilter(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
