import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String mockInput = request.getParameter("mock");
                    org.joychou.controller.CommandInject ctr0 = new org.joychou.controller.CommandInject();
                    ctr0.codeInject(             mockInput   );
                    ctr0.codeInjectHost(             request   );
                    ctr0.codeInjectSec(             mockInput   );
                            org.joychou.controller.Cookies ctr1 = new org.joychou.controller.Cookies();
                    ctr1.vuln01(             request   );
                    ctr1.vuln02(             request   );
                    ctr1.vuln03(             request   );
                    ctr1.vuln04(             request   );
                    ctr1.vuln05(             mockInput   );
                    ctr1.vuln06(             mockInput   );
                            org.joychou.controller.Cors ctr2 = new org.joychou.controller.Cors();
                    ctr2.vuls1(             request  ,             response   );
                    ctr2.vuls2(             response   );
                    ctr2.vuls3( );
                    ctr2.vuls3( );
                    ctr2.secCrossOrigin( );
                    ctr2.getCsrfToken_01(             mockInput   );
                    ctr2.getCsrfToken_02(             mockInput   );
                    ctr2.getCsrfToken_03(             mockInput   );
                    ctr2.getCsrfToken_04(             mockInput   );
                    ctr2.seccode(             request  ,             response   );
                            org.joychou.controller.Deserialize ctr3 = new org.joychou.controller.Deserialize();
                    ctr3.rememberMeVul(             request   );
                    ctr3.rememberMeBlackClassCheck(             request   );
                    ctr3.Jackson(             mockInput   );
                            org.joychou.controller.GetRequestURI ctr4 = new org.joychou.controller.GetRequestURI();
                    ctr4.exclued(             request   );
                            org.joychou.controller.IPForge ctr5 = new org.joychou.controller.IPForge();
                    ctr5.noProxy(             request   );
                    ctr5.proxy(             request   );
                            org.joychou.controller.Jdbc ctr6 = new org.joychou.controller.Jdbc();
                    ctr6.postgresql(             mockInput   );
                    ctr6.db2(             mockInput   );
                            org.joychou.controller.Jsonp ctr7 = new org.joychou.controller.Jsonp();
                    ctr7.referer(             request   );
                    ctr7.emptyReferer(             request   );
                    ctr7.advice(             request   );
                    ctr7.mappingJackson2JsonView(             request   );
                    ctr7.safecode(             request   );
                    ctr7.getCsrfToken1(             mockInput   );
                    ctr7.getCsrfToken2(             request   );
                            org.joychou.controller.Jwt ctr8 = new org.joychou.controller.Jwt();
                    ctr8.createToken(             response  ,             request   );
                    ctr8.getNickname(             mockInput   );
                            org.joychou.controller.Log4j ctr9 = new org.joychou.controller.Log4j();
                    ctr9.log4j(             mockInput   );
                            org.joychou.controller.PathTraversal ctr10 = new org.joychou.controller.PathTraversal();
                    ctr10.getImage(             mockInput   );
                    ctr10.getImageSec(             mockInput   );
                            org.joychou.controller.QLExpress ctr11 = new org.joychou.controller.QLExpress();
                    ctr11.vuln1(             request   );
                    ctr11.sec(             request   );
                            org.joychou.controller.Rce ctr12 = new org.joychou.controller.Rce();
                    ctr12.CommandExec(             mockInput   );
                    ctr12.processBuilder(             mockInput   );
                    ctr12.jsEngine(             mockInput   );
                    ctr12.yarm(             mockInput   );
                    ctr12.secYarm(             mockInput   );
                    ctr12.groovyshell(             mockInput   );
                            org.joychou.controller.Shiro ctr13 = new org.joychou.controller.Shiro();
                    ctr13.shiro_deserialize(             request  ,             response   );
                            org.joychou.controller.SpEL ctr14 = new org.joychou.controller.SpEL();
                    ctr14.spel_vuln1(             mockInput   );
                    ctr14.spel_vuln2(             mockInput   );
                    ctr14.spel_sec(             mockInput   );
                            org.joychou.controller.SQLI ctr15 = new org.joychou.controller.SQLI();
                    ctr15.jdbc_sqli_vul(             mockInput   );
                    ctr15.jdbc_sqli_sec(             mockInput   );
                    ctr15.jdbc_ps_vuln(             mockInput   );
                    ctr15.mybatisVuln01(             mockInput   );
                    ctr15.mybatisVuln02(             mockInput   );
                    ctr15.mybatisVuln03(             mockInput   );
                    ctr15.mybatisSec01(             mockInput   );
                    ctr15.mybatisSec02(             mockInput   );
                    ctr15.mybatisSec03( );
                    ctr15.mybatisOrderBySec04(             mockInput   );
                            org.joychou.controller.SSRF ctr16 = new org.joychou.controller.SSRF();
                    ctr16.URLConnectionVuln(             mockInput   );
                    ctr16.URLConnectionSec(             mockInput   );
                    ctr16.httpURLConnection(             mockInput   );
                    ctr16.httpURLConnectionVuln(             mockInput   );
                    ctr16.request(             mockInput   );
                    ctr16.openStream(             mockInput  ,             response   );
                    ctr16.ImageIO(             mockInput   );
                    ctr16.okhttp(             mockInput   );
                    ctr16.HttpClient(             mockInput   );
                    ctr16.commonsHttpClient(             mockInput   );
                    ctr16.Jsoup(             mockInput   );
                    ctr16.IOUtils(             mockInput   );
                    ctr16.HttpSyncClients(             mockInput   );
                    ctr16.RestTemplateUrlBanRedirects(             mockInput   );
                    ctr16.RestTemplateUrl(             mockInput   );
                    ctr16.hutoolHttp(             mockInput   );
                    ctr16.DnsRebind(             mockInput   );
                            org.joychou.controller.SSTI ctr17 = new org.joychou.controller.SSTI();
                    ctr17.velocity(             mockInput   );
                            org.joychou.controller.URLWhiteList ctr18 = new org.joychou.controller.URLWhiteList();
                    ctr18.endsWith(             mockInput   );
                    ctr18.contains(             mockInput   );
                    ctr18.regex(             mockInput   );
                    ctr18.url_bypass(             mockInput  ,             response   );
                    ctr18.sec(             mockInput   );
                    ctr18.sec_array_indexOf(             mockInput   );
                            org.joychou.controller.WebSockets ctr19 = new org.joychou.controller.WebSockets();
                    ctr19.cmdInject(             request   );
                    ctr19.proxyInject(             request   );
                            org.joychou.controller.XStreamRce ctr20 = new org.joychou.controller.XStreamRce();
                            org.joychou.controller.XXE ctr21 = new org.joychou.controller.XXE();
                    ctr21.xmlReaderSec(             request   );
                    ctr21.SAXBuilderVuln(             request   );
                    ctr21.SAXBuilderSec(             request   );
                    ctr21.SAXReaderVuln(             request   );
                    ctr21.SAXReaderSec(             request   );
                    ctr21.SAXParserVuln(             request   );
                    ctr21.SAXParserSec(             request   );
                    ctr21.DigesterVuln(             request   );
                    ctr21.DigesterSec(             request   );
                    ctr21.DocumentBuilderVuln(             request   );
                    ctr21.DocumentBuilderSec(             request   );
                    ctr21.DocumentBuilderXincludeVuln(             request   );
                    ctr21.DocumentBuilderXincludeSec(             request   );
                        response.getWriter().println("Hello, this is my servlet!");
        } catch (Exception e) {
                      throw new RuntimeException(e);
        }
    }
}