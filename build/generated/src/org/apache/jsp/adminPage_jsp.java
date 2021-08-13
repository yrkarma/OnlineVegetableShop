package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class adminPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/grocery.css\">\n");
      out.write("<title>Admin Page</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<nav class=\"fixed-nav-bar-top\">\n");
      out.write("\t<ul class=\"nav\">\n");
      out.write("\t\t<li><a href=\"index.html\" target=\"\">Home</a></li>\n");
      out.write("\t\t<li><a href=\"categories.jsp\" target=\"\">Categories</a></li>\n");
      out.write("\t\t<li><a href=\"About Us.html\" target=\"\">About Us</a></li>\n");
      out.write("\t\t<li><a href=\"ContactUs.html\" target=\"\">Contact Us</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t</nav>\n");
      out.write("\n");
      out.write("\t<form method=\"GET\" action=\"ProductList.jsp\" id=\"searchform\">\n");
      out.write("\t\t<input type=\"text\" name=\"search\"> <input type=\"submit\"\n");
      out.write("\t\t\tname=\"submit\" value=\"Search\">\n");
      out.write("\t</form>\n");
      out.write("\t");

	//public Object getAttribute(String name)
	//This method returns the object bound with the specified name in this session, or null if no object is bound under the name.
		String status = (String)session.getAttribute("Admin");	
		if(status == null || !status.equals("1")){
			response.sendRedirect("adminLogin.jsp?status=2");
		}
	
      out.write("\n");
      out.write("\t<div align=\"center\" style=\"padding-top: 5%;\">\n");
      out.write("\t <a href=\"adminPage.jsp?select=1\"><button>Products</button></a><br>\n");
      out.write("\t\t<br> <a href=\"adminPage.jsp?select=2\"><button>Customers</button></a><br>\n");
      out.write("\t\t<br> <a href=\"adminPage.jsp?select=3\"><button>Orders</button></a><br>\n");
      out.write("\t\t<br>\n");
      out.write("\t</div>\n");
      out.write("\t");

		String select = request.getParameter("select");
		if(select != null){
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
		    if(select.equals("1"))	{
		    	String sql = "SELECT * from product_details";
		    	ResultSet rs = conn.createStatement().executeQuery(sql);
		    	
      out.write("<table border=\"1\" align=\"center\">\n");
      out.write("\t\t<tr align=\"center\">\n");
      out.write("\t\t\t<th>Product ID</th>\n");
      out.write("\t\t\t<th>Product Name</th>\n");
      out.write("\t\t\t<th>Price</th>\n");
      out.write("\t\t\t<th>Delete</th>\n");
      out.write("\t\t\t<th>Edit</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
while(rs.next())	{
		    			int id=rs.getInt("product_id");
		    			String name = rs.getString("product_name");
		    			double price = rs.getDouble("product_price");
		    		
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>");
      out.print(id );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(name );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(price );
      out.write("</td>\n");
      out.write("\t\t\t<td><a href=\"DeleteItem?id=");
      out.print(id);
      out.write("&type=1\"><img\n");
      out.write("\t\t\t\t\tsrc=\"./Images/deleteIcon.png\" width=\"30px\" height=\"30px\" /></a>\n");
      out.write("\t\t\t<td><a href=\"adminUpdateProduct.jsp?id=");
      out.print(id);
      out.write("\"><img\n");
      out.write("\t\t\t\t\tsrc=\"./Images/editcon.png\" width=\"30px\" height=\"30px\" /></a>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
}
		    			
      out.write("\n");
      out.write("\t</table>\n");
      out.write("\t<div align=\"center\" margin=\"2px\">\n");
      out.write("\t\t<a href=\"adminAddProduct.jsp\"><button>Add product</button></a>\n");
      out.write("\t</div>\n");
      out.write("\t");

		    }else if(select.equals("2"))	{
		    	String sql = "SELECT * from customer_details";
		    	ResultSet rs = conn.createStatement().executeQuery(sql);
		    	
      out.write("<table border=\"1\" align=\"center\">\n");
      out.write("\t\t<tr align=\"center\">\n");
      out.write("\t\t\t<th>Customer ID</th>\n");
      out.write("\t\t\t<th>Customer Name</th>\n");
      out.write("\t\t\t<th>Phone Number</th>\n");
      out.write("\t\t\t<th>Delete</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
while(rs.next())	{
		    			int id=rs.getInt("cust_id");
		    			String name = rs.getString("name");
		    			String phone = rs.getString("phone_no");
		    		
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>");
      out.print(id );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(name );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(phone );
      out.write("</td>\n");
      out.write("\t\t\t<td><a href=\"DeleteItem?id=");
      out.print(id);
      out.write("&type=2\"><img\n");
      out.write("\t\t\t\t\tsrc=\"./Images/deleteIcon.png\" width=\"30px\" height=\"30px\" /></a>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
}
		    			
      out.write("\n");
      out.write("\t</table>\n");
      out.write("\t");

		    }else if(select.equals("3"))	{
		    	String sql = "SELECT order_no,quantity, customer_details.Name, product_details.product_name, product_price FROM order_details,product_details,customer_details WHERE order_details.prod_ID=product_details.product_id and order_details.cust_ID=customer_details.cust_ID";
		    	ResultSet rs = conn.createStatement().executeQuery(sql);
		    	
      out.write("<table border=\"1\" align=\"center\">\n");
      out.write("\t\t<tr align=\"center\">\n");
      out.write("\t\t\t<th>Order ID</th>\n");
      out.write("\t\t\t<th>Customer Name</th>\n");
      out.write("\t\t\t<th>Product Name</th>\n");
      out.write("\t\t\t<th>Quantity</th>\n");
      out.write("\t\t\t<th>Cost</th>\n");
      out.write("\t\t\t<th>Delete</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
while(rs.next())	{
		    			int id=rs.getInt("order_no");
		    			String pname = rs.getString("product_name");
		    			double price = rs.getDouble("product_price");
		    			String cname = rs.getString("name");
		    			int quantity = rs.getInt("quantity");
		    			double total = price*quantity;
		    		
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>");
      out.print(id );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(cname );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(pname );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(quantity );
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(total );
      out.write("</td>\n");
      out.write("\t\t\t<td><a href=\"DeleteItem?id=");
      out.print(id);
      out.write("&type=3\"><img\n");
      out.write("\t\t\t\t\tsrc=\"./Images/deleteIcon.png\" width=\"30px\" height=\"\" /></a>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
}
		    			
      out.write("\n");
      out.write("\t</table>\n");
      out.write("\t");

		    }
	
      out.write('\n');
      out.write('	');
}
      out.write("\n");
      out.write("\t<div align=\"center\">\n");
      out.write("\t\t<a href=\"adminLogout\"><button>Logout</button></a>\n");
      out.write("\t</div>\n");
      out.write("\n");
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
