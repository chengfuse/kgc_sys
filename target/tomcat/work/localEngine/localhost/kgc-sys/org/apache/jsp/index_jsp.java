package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/jsp/common/common-header.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    ");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/kgc_sys_war/layui/css/layui.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/kgc_sys_war/js/jquery-3.5.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/kgc_sys_war/layui/layui.js\"></script>");
      out.write("\n");
      out.write("</head>\n");
      out.write("<title>登录页面</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("    .login_button{\n");
      out.write("        width: 150px;\n");
      out.write("        height: 36px;\n");
      out.write("        border-radius: 4px;\n");
      out.write("        border: none;\n");
      out.write("        color: #FFFFFF;\n");
      out.write("        background:#4fddfb;\n");
      out.write("        background:-moz-linear-gradient(left, #4fddfb, rgba(42, 106, 253, 0.5));\n");
      out.write("        background:-webkit-gradient(linear, 0 18, right 18, from(#4fddfb), to(rgba(42, 106, 253, 0.5)));\n");
      out.write("        background:-o-linear-gradient(left, #4fddfb, rgba(42, 106, 253, 0.5));\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("    //JavaScript代码区域\n");
      out.write("    layui.use('form', function(){\n");
      out.write("        var  form=layui.form;\n");
      out.write("        //监听提交\n");
      out.write("        form.on('submit(formDemo)', function(data){\n");
      out.write("            layer.msg(JSON.stringify(data.field));\n");
      out.write("            return false;\n");
      out.write("        });\n");
      out.write("        //自定义验证规则\n");
      out.write("        form.verify({\n");
      out.write("            username: [\n");
      out.write("                /^[\\S]{6,12}$/\n");
      out.write("                ,'用户名必须6到12位，且不能出现空格'\n");
      out.write("            ],\n");
      out.write("            password: [\n");
      out.write("                /^[\\S]{6,12}$/\n");
      out.write("                ,'密码必须6到12位，且不能出现空格'\n");
      out.write("            ]\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body style=\"text-align: center\">\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 50px;\">\n");
      out.write("    <legend>登录</legend>\n");
      out.write("</fieldset>\n");
      out.write("<div class=\"layui-form\"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->\n");
      out.write("    <div class=\"layui-form-item\" style=\"padding-left: 33%\">\n");
      out.write("        <label class=\"layui-form-label\">用户名</label>\n");
      out.write("        <div class=\"layui-input-inline\">\n");
      out.write("            <input type=\"text\" name=\"username\"   lay-verify=\"username\"  autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"layui-form-item\" style=\"padding-left: 33%\">\n");
      out.write("        <label class=\"layui-form-label\">密码</label>\n");
      out.write("        <div class=\"layui-input-inline\">\n");
      out.write("            <input type=\"password\" name=\"password\" lay-verify=\"password\"  autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"layui-form-item\">\n");
      out.write("        <div>\n");
      out.write("            <button id=\"login_button\" class=\"login_button\">登录</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        //登录后用户名或密码错误给出提示\n");
      out.write("        var flag ='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flag}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\n");
      out.write("        if (flag =='error'){\n");
      out.write("            layer.msg(\"用户名或密码错误\",{\"time\":100});\n");
      out.write("        }\n");
      out.write("        $('#login_button').click(function () {\n");
      out.write("            login();\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    function login() {\n");
      out.write("        var un = $('input[name=\"username\"]').val();\n");
      out.write("        if(!un || un === '') {\n");
      out.write("            layer.msg(\"用户名不能为空\",{\"time\":100});\n");
      out.write("            return;\n");
      out.write("        }\n");
      out.write("        var pw = $('input[name=\"password\"]').val();\n");
      out.write("        if(!pw || pw === '') {\n");
      out.write("            layer.msg(\"密码不能为空\",{\"time\":100});\n");
      out.write("            return;\n");
      out.write("        }\n");
      out.write("        $.ajax('/kgc_sys_war/login', {\n");
      out.write("            data: {\n");
      out.write("                \"userName\": un,\n");
      out.write("                \"pwd\": pw\n");
      out.write("            },\n");
      out.write("            type: 'POST',\n");
      out.write("            dataType:'json',\n");
      out.write("            success: function (ret) {\n");
      out.write("                if (ret =='success') {\n");
      out.write("                    window.location.href = \"/kgc_sys_war/toMain\";\n");
      out.write("                } else {\n");
      out.write("                    layer.msg(\"登录失败\",{\"time\":1000});\n");
      out.write("                }\n");
      out.write("            },\n");
      out.write("            error: function (xhr) {\n");
      out.write("                layer.msg('登录失败',{\"time\":1000});\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
