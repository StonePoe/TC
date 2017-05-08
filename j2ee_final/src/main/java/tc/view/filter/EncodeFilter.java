package tc.view.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by stonezhang on 2016/12/20.
 */
public class EncodeFilter implements Filter {

    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
//        System.out.println(encode);
        if(encode!=null){
            servletRequest.setCharacterEncoding(encode);
            servletResponse.setContentType("text/html;charset=UTF-8");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

}
