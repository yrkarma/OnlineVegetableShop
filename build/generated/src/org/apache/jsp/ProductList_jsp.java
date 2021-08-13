package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ProductList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\n");
      out.write("\n");

	String URL = "jdbc:mysql://localhost:3306/grocery_DB";
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String USER = "root";
	String PASS = "toor";
	Connection conn = null;
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(URL, USER, PASS);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/ProductList.css\">\n");
      out.write("<title>Fruits and Vegetables</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<ul class=\"nav\">\n");
      out.write("\t\t<li><a href=\"index.html\" target=\"\">Home</a></li>\n");
      out.write("\t\t<li><a href=\"categories.jsp\" target=\"\">Categories</a></li>\n");
      out.write("\t\t<li><a href=\"About Us.html\" target=\"\">About Us</a></li>\n");
      out.write("\t\t<li><a href=\"ContactUs.html\" target=\"\">Contact Us</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t<form method=\"GET\" action=\"ProductList.jsp\" id=\"searchform\">\n");
      out.write("\t\t<input type=\"text\" name=\"search\"> <input type=\"submit\"\n");
      out.write("\t\t\tname=\"submit\" value=\"Search\">\n");
      out.write("\t</form>\n");
      out.write("\t");

		String query = "SELECT * FROM product_details WHERE ";
		if (request.getParameter("id") != null) {
			int catId = Integer.parseInt(request.getParameter("id"));
			query += "cat_id=" + catId;
		} else if (request.getParameter("search") != null) {
			String searchString = request.getParameter("search");
			query += "product_name LIKE '%" + searchString + "%'";
		}
		System.out.println("Query: " + query);
		ResultSet rs = conn.createStatement().executeQuery(query);
	
      out.write("\n");
      out.write("\t<ul class=\"wrapper\">\n");
      out.write("\t\t");

			while (rs.next()) {
				int id = rs.getInt("product_id");
		
      out.write("\n");
      out.write("\t\t<li class=\"box\"><a href=\"ProductInfo.jsp?id=");
      out.print(id);
      out.write("\"><img\n");
      out.write("\t\t\t\tsrc=\"./Images/");
      out.print(rs.getString("prod_img"));
      out.write("\"\n");
      out.write("\t\t\t\talt=\"");
      out.print(rs.getString("product_name"));
      out.write("\"\n");
      out.write("\t\t\t\tstyle=\"width: 150px; height: 150px;\"> ");
      out.print(rs.getString("product_name"));
      out.write("</a></li>\n");
      out.write("\t\t");

			}
		
      out.write("\n");
      out.write("\t</ul>\n");
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
