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
<%
    String path = request.getContextPath();

%>
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
    <style type="text/css">
        #divmain{
            position: relative;
        }
        #divleft{
            float: left;
            margin: 10px;
        }
        #up{
            osition:relative;
            z-index:99999;
        }
        div{
            float:left;
            margin-left: 30px;
            margin-right:30px;
            margin-top: 5px;
            margin-bottom: 5px;
        }
      #cart {
            margin:0px auto;
            text-align:right;
        }

    </style>
    <script type="text/javascript">
        function selflog_show(id)
        {
            var num =  document.getElementById("number").value;
            J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/servlet/CartServlet?id='+id+'&num='+num+'&action=add', cover:true});
        }
        function add()
        {
            var num = parseInt(document.getElementById("number").value);
            if(num<100)
            {
                document.getElementById("number").value = ++num;
            }
        }
        function sub()
        {
            var num = parseInt(document.getElementById("number").value);
            if(num>1)
            {
                document.getElementById("number").value = --num;
            }
        }

    </script>
</head>
<body>
<h1>商品展示</h1>
<a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
<hr/>

<table width="750" height="60" cellpadding="0" cellspacing="0" border="0" align="center">
    <tr>
                <%
                    ItemsDAO itemsDAO = new ItemsDAO();
                    Items item = itemsDAO.getItemById(Integer.parseInt(request.getParameter("id")));
                    if(item!=null)
                    {
                %>
        <td width="70%" valign="top">
           <table>
               <tr>
                   <td rowspan="4"><img src="images/<%=item.getPicture()%>" width="200" height="160"/></td>
               <tr>
                    <td><B><%=item.getName()%></B></td>
               </tr>
               <tr>
                   <td> 产地:<%=item.getCity()%>&nbsp;&nbsp;</td>
               </tr>
               <tr>
                   <td>价格￥:<%=item.getPrice()%></td>
               </tr>
               <tr>
                   <td>购买数量：<span id="sub" onclick="sub();">-</span>
                       <input type="text" id="number" name="number" value="1" size="2"/>
                       <span id="add" onclick="add();">+</span></td>
               </tr>
               <div id="cart">

                   <img src="images/buy_now.png">
                   <a href="javascript:selflog_show(<%=item.getId()%>)"><img src="images/in_cart.png"></a>
                   <a href="servlet/CartServlet?action=show"><img src="images/view_cart.jpg"/></a>

               </div>
           </table>



       </td>
        <%

            }
        %>

        <%
            String list="";
            Cookie[] cookies = request.getCookies();
            if(cookies!=null&&cookies.length>0){
            for (Cookie c: cookies) {
                if(c.getName().equals("ListViewCookie")){
                    list = c.getValue();
                }
            }
           }
            list+=request.getParameter("id")+"/";
            String[] arr=list.split("/");
            if(arr != null && arr.length>0){
                if(arr.length>=1000){
                    list="";
                }
            }
            Cookie cookie = new Cookie("ListViewCookie",list);
            response.addCookie(cookie);
        %>
        <!-- 浏览过的商品 -->
        <td width="30%" bgcolor="#EEE" align="center">
            <br>
            <b>您浏览过的商品</b><br>
            <%
                ArrayList<Items> itemlist = itemsDAO.getViewList(list);
                if(itemlist!=null&&itemlist.size()>0){
                    for (Items i : itemlist) {
                      

                %>


            <a href="details.jsp?id=<%=i.getId()%>"><img src="images/<%=i.getPicture()%>" width="200" height="160"/></a><br/>

            <B><%=i.getName()%></B><br/>
            产地:<%=i.getCity()%>&nbsp;&nbsp;<br/>
             价格￥:<%=i.getPrice()%><br/>
    <%
            }
        }
    %>
</table>

</body>
</html>
