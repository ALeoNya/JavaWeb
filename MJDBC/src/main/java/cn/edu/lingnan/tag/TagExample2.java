package cn.edu.lingnan.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TagExample2 extends TagSupport {
    private String name;
    public void setName(String name){ this.name = name; }
    public String getName(){ return this.name; }
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("Hello " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
