/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2022-06-17 03:17:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.test.WeatherDTO;
import java.util.ArrayList;
import com.test.WeatherDAO;

public final class WeatherInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1655432182669L));
    _jspx_dependants.put("jar:file:/C:/XmlStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/XmlApp08/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.test.WeatherDAO");
    _jspx_imports_classes.add("com.test.WeatherDTO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

      out.write('\r');
      out.write('\n');

	//???????????? ????????? ?????? ????????? ??????
	String stnId = request.getParameter("stnId");
	if(stnId==null)
	{
		stnId = "108";		// ?????? ?????? ??????
	}
	
	StringBuilder sb = new StringBuilder();
	WeatherDAO dao = new WeatherDAO(stnId);
	
	// ?????????
	String title = dao.weatherTitle();
	
	// ?????? ?????? ??????
	String weatherInfo = dao.weatherInfo();
	
	// ?????? ?????? ??? ?????? ????????? ?????? ??????
	ArrayList<String> cityList = dao.weatherCityList();
	for(int a=0; a<cityList.size(); a++)
	{
		sb.append(String.format("<h3>%s</h3>", cityList.get(a)));
		
		ArrayList<WeatherDTO> weatherList = dao.weatherList(String.valueOf(a+1));
		
		// ????????? ?????? ??????
		sb.append("<table class='table'>");
		sb.append("<tr>");
		sb.append("<th>??????</th>");
		sb.append("<th>??????</th>");
		sb.append("<th>??????/?????? ??????</th>");
		sb.append("<th>????????????</th>");
		sb.append("</tr>");
		
		for(WeatherDTO w : weatherList)
		{
			sb.append("<tr>");
			sb.append(String.format("<td>%s</td>", w.getTmEf()));
			sb.append(String.format("<td><img src='images/%s'/> %s</td>"
										, w.getImg(), w.getWf()));
			sb.append(String.format("<td>%s??? / %s???</td>"
										, w.getTmn(), w.getTmx()));
			sb.append(String.format("<td>%s%%</td>", w.getRnSt()));
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>????????? ?????? ?????? ?????? (WeatherInfo.jsp)</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function()\r\n");
      out.write("\t{\r\n");
      out.write("\t\t// ??????\r\n");
      out.write("\t\t//alert(\"??????~!!!\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// ????????? ????????? ????????? ????????? ????????? ??????(checked)??? ????????? ??? ????????? ??????\r\n");
      out.write("\t\t// $(\":radio:eq(0)\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t//\t\t\t\t\t:\r\n");
      out.write("\t\t// $(\":radio:eq(2)\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t//\t\t\t\t\t:\r\n");
      out.write("\t\t// $(\":radio:eq(9)\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t//\t\t\t\t\t:\r\n");
      out.write("\t\t// $(\":radio:[value='108']\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t//\t\t\t\t\t:\r\n");
      out.write("\t\t// $(\":radio:[value='146']\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t//\t\t\t\t\t:\r\n");
      out.write("\t\t// $(\":radio:[value='184']\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t$(\":radio[value='");
      out.print(stnId);
      out.write("']\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("stinId=108\t\t??????\r\n");
      out.write("stinId=109\t\t??????,??????\r\n");
      out.write("stinId=105\t\t??????\r\n");
      out.write("stinId=131\t\t??????\r\n");
      out.write("stinId=133\t\t??????\r\n");
      out.write("stinId=146\t\t??????\r\n");
      out.write("stinId=156\t\t??????\r\n");
      out.write("stinId=143\t\t??????\r\n");
      out.write("stinId=159\t\t??????\r\n");
      out.write("stinId=184\t\t?????????????????????\r\n");
      out.write(" -->\r\n");
      out.write(" \r\n");
      out.write(" <div class=\"container\">\r\n");
      out.write(" \r\n");
      out.write(" \t<h2>\r\n");
      out.write(" \t\t?????? ?????? <small>?????? ??????</small>\r\n");
      out.write(" \t</h2>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"panel-group\" role=\"group\">\r\n");
      out.write("\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">?????? ??????</div>\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<!-- action ?????? ?????? ??? ?????? ??? ???????????? ?????? ?????? ~!!! -->\r\n");
      out.write("\t\t\t\t<form method=\"get\" role=\"form\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"108\" checked=\"checked\"/>??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"109\" />??????,??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"105\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"131\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"133\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"146\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"156\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"143\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"159\" />??????\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"184\" />?????????????????????\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">Submit</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div><!-- close panel-body -->\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- close .panel .panel-default -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"panel panel-default\" role=\"group\">\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">?????? ?????? ??????</div>\r\n");
      out.write("\t\t\t<div class=\"paenl-body\">\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<!-- <b>??????,????????? ?????? ???????????? - 2022??? 06??? 16??? (???)?????? 06:00 ??????</b> -->\r\n");
      out.write("\t\t\t\t\t<b>");
      out.print(title );
      out.write("</b>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t??? (????????????) ?????? ??????????????? ????????? ??????????????????.<br />\r\n");
      out.write("\t\t\t\t\t??? (??????) ?????? ???????????? ?????? ????????? 18~22???, ??? ????????? 25~31?????? ??????(15???, ?????????????????? 14~15???, ??????????????? 17~25???)?????? ???????????????.<br />\r\n");
      out.write("\t\t\t\t\t??? (??????) ????????????????????? ????????? 21???(???)??? 22???(???)??? 1.0~2.5m??? ?????????, ??? ?????? ?????? 0.5~2.0m??? ???????????????.<br />\r\n");
      out.write("\t\t\t\t\t??? (????????????) 18???(???)~19???(???)??? ????????? ????????????, ?????? ????????? 19~21???, ??? ????????? 26~31?????? ???????????????.<br /><br />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t* 20???(???) ?????? ???????????? ????????? ????????? ????????? ?????? ?????? ????????? ????????? ???????????? ?????? ????????????, ????????? ???????????? ????????? ??????????????? ???????????? ????????????.\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t\t ");
      out.print(weatherInfo );
      out.write("\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t<h3>??????</h3>\r\n");
      out.write("\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>??????</th>\r\n");
      out.write("\t\t\t\t\t\t<th>??????</th>\r\n");
      out.write("\t\t\t\t\t\t<th>??????/?????? ??????</th>\r\n");
      out.write("\t\t\t\t\t\t<th>????????????</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-19 00:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>??????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>21 ~ 29</td>\r\n");
      out.write("\t\t\t\t\t\t<td>40\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-19 12:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>21 ~ 29</td>\r\n");
      out.write("\t\t\t\t\t\t<td>20\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-20 00:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>??????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>22 ~ 30</td>\r\n");
      out.write("\t\t\t\t\t\t<td>40\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-20 12:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>22 ~ 30</td>\r\n");
      out.write("\t\t\t\t\t\t<td>30\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3>??????</h3>\r\n");
      out.write("\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>??????</th>\r\n");
      out.write("\t\t\t\t\t\t<th>??????</th>\r\n");
      out.write("\t\t\t\t\t\t<th>??????/?????? ??????</th>\r\n");
      out.write("\t\t\t\t\t\t<th>????????????</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-19 00:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>??????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>21 ~ 29</td>\r\n");
      out.write("\t\t\t\t\t\t<td>40\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-19 12:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>21 ~ 29</td>\r\n");
      out.write("\t\t\t\t\t\t<td>20\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-20 00:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>??????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>22 ~ 30</td>\r\n");
      out.write("\t\t\t\t\t\t<td>40\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>2022-06-20 12:00</td>\r\n");
      out.write("\t\t\t\t\t\t<td>????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td>22 ~ 30</td>\r\n");
      out.write("\t\t\t\t\t\t<td>30\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t-->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      out.print(sb.toString() );
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div> \t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
