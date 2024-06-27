package org.oarmour.security.main;

import org.apache.jasper.JspC;

public class JspConverterMain {
    public static void main(String[] args) {
        try {
            JspC jspC = new JspC();
            jspC.setUriroot(".");
            jspC.setJspFiles(args[0]);
            jspC.setOutputDir(args[1]);
            jspC.setCompile(true);
            jspC.setCompilerTargetVM("1.8");
            jspC.execute();
            System.out.println("JSP compilation completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
