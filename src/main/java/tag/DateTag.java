package tag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		Date now=new Date();
		JspWriter out=this.getJspContext().getOut();
		out.print(now.toLocaleString());
		out.close();
	}
}
