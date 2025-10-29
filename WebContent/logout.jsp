<%@ page %>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
