package tc.view.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by stonezhang on 2016/12/30.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession(false);
//        if((session != null) && (session.getAttribute("isLogin") == null)) {
        String formURL = ((HttpServletRequest)servletRequest).getHeader("Referer");
//        System.out.println(formURL);
        if((formURL == null || !formURL.contains("login")) && session.getAttribute("isLogin") == null) {
//            System.out.println("filter not auth");
            ((HttpServletResponse) servletResponse).sendRedirect(
                    ((HttpServletRequest)servletRequest).getContextPath() + "/login");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
