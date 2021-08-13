package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.sql.*;

public final class adminAddProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\t");

		String status = (String)session.getAttribute("Admin");	
		if(status == null || !status.equals("1")){
			response.sendRedirect("adminLogin.jsp?status=2");
		}
	
      out.write("\n");
      out.write("\t\n");
      out.write(" \n");
      out.write(" ");

    String URL = "jdbc:mysql://localhost:3306/grocery_DB";
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String USER = "root";
    String PASS = "toor";
    Connection conn=null;
    try {
    	Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(URL,USER,PASS);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    ResultSet rs = conn.createStatement().executeQuery("Select * from category");
 
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/sign_up.css\">\n");
      out.write("<title>Add New Product</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<div id=\"Sign-Up\"> \n");
      out.write("\t\t<fieldset style=\"width:30%\">\n");
      out.write("\t\t\t<legend>Add a new Product</legend> \n");
      out.write("\t\t\t\t<table class=\"center\" border=\"0\"> <tr> \n");
      out.write("\t\t\t\t\t<form method=\"GET\" action=\"AddProduct\"> \n");
      out.write("\t\t\t\t\t\t<td>Product Name</td>\n");
      out.write("\t\t\t\t\t\t<td> <input type=\"text\" name=\"pname\"></td>\n");
      out.write(" \t\t\t\t\t\t</tr> \n");
      out.write(" \t\t\t\t\t\t<tr> <td>Category</td>\n");
      out.write(" \t\t\t\t\t\t<td> <select name=\"cat\">\n");
      out.write("\t\t\t\t\t");
while(rs.next()){
						String cat = rs.getString("category_name");
						int id = rs.getInt("category_id");
						
      out.write("<option value=\"");
      out.print(id );
      out.write("\"> ");
      out.print(cat );
      out.write("</option>\n");
      out.write("\t\t\t\t\t");
}
      out.write("\n");
      out.write("\t\t\t\t</select></td> </tr>\n");
      out.write(" \t\t\t\t\t\t<tr> <td>Price</td>\n");
      out.write(" \t\t\t\t\t\t<td> <input type=\"number\" name=\"price\" step=\"0.01\"></td> </tr>\n");
      out.write(" \t\t\t\t\t\t<tr> <td>Product Image file name</td><td>\n");
      out.write(" \t\t\t\t\t\t<input type=\"text\" name=\"img\"></td> </tr>\n");
      out.write(" \t\t\t\t\t\t<tr> <td>Product Description </td>\n");
      out.write(" \t\t\t\t\t\t<td><textarea name=\"desc\"></textarea></td> </tr> \n");
      out.write("\t\t\t\t\t\t <tr> <td><input type=\"Submit\" value=\"Add product\"/>\n");
      out.write("\t\t\t\t\t\t<input type=\"reset\" value=\"reset\"/></td> </tr> \n");
      out.write("\t\t\t\t\t </form> \n");
      out.write(" \t\t\t\t</table> \n");
      out.write(" \t\t</fieldset> \n");
      out.write("\t\n");
      out.write("\t\n");
      out.write(" \t</div>\n");
      out.write("\t<a href=\"adminPage.jsp\"><button>Back</button></a>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
