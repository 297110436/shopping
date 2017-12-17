<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Items" %>
<%@ page import="dao.ItemsDAO" %><%--
  Created by IntelliJ IDEA.
  User: 29711
  Date: 2017/8/16
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
  <head>
    <style type="text/css">
    #divmain{
      position: relative;
    }
      #divleft{
        float: left;
        margin: 10px;
      }

    </style>
  </head>
  <body>
  <h1>商品展示</h1>
  <hr/>

  <table width="750" height="60" cellpadding="0" cellspacing="0" border="0" align="center">
    <tr>
      <td>
<div id="divmain">

      <%
        ItemsDAO itemsDAO = new ItemsDAO();
        ArrayList<Items> list = itemsDAO.getAllItems();
        if(list!=null&&list.size()>0)
        {
          for (int i = 0; i < list.size(); i++)
          {
            Items item=list.get(i);%>
        <div id="divleft">

        <a href="details.jsp?id=<%=item.getId()%>"><img src="images/<%=item.getPicture()%>"  width="120" height="90" border="1"/></a><br/>
   <a href="#"><%=item.getName()%></a><br/>
    产地:<%=item.getCity()%>&nbsp;&nbsp;<br/>
    价格￥:<%=item.getPrice()%><br/>


        </div>


    <%
        }
      }
    %>
</div>
      </td>
    </tr>
  </table>

  </body>
</html>
