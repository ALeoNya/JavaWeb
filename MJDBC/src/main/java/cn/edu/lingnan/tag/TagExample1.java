package cn.edu.lingnan.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TagExample1 extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("hello 444444");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
