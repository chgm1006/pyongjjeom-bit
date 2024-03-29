sun.boot.class.path :

<%=System.getProperty("sun.boot.class.path")%>

sun.boot.library.path :

<%=System.getProperty("sun.boot.library.path")%>

java.library.path :

<%=System.getProperty("java.library.path")%>

java.class.path :

<%=System.getProperty("java.class.path")%>

getClassLoader() :

<%=this.getClass().getClassLoader()%>

DocumentBuilderFactory :

<%=javax.xml.parsers.DocumentBuilderFactory.newInstance()%>

/javax/xml.parsers/DocumentBuilderFactory.class : 20.
<%=this.getClass().getResource("/javax/xml.parsers/DocumentBuilderFactory.class")%>

SAXParserFactory :

<%=javax.xml.parsers.SAXParserFactory.newInstance()%>
/javax/xml/parsers/SAXParserFactory.class :

<%=this.getClass().getResource("/javax/xml/parsers/SAXParserFactory.class")%>

TransformerFactory :

<%=javax.xml.transform.TransformerFactory.newInstance()%>

/javax/xml/transform/TransformerFactory.class :

<%=this.getClass().getResource("/javax/xml/transform/TransformerFactory.class")%>

Servlet :

<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>

JSP :

<%=javax.servlet.jsp.JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion()%>

ServerInfo :

<%=application.getServerInfo()%>

RealPath :

<%=application.getRealPath("/")%>

ContextPath :

<%=request.getContextPath()%>

totalMemory :

<%=Runtime.getRuntime().totalMemory()%>

maxMemory :

<%=Runtime.getRuntime().maxMemory()%>

freeMemory :

<%=Runtime.getRuntime().freeMemory()%>