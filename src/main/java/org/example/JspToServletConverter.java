package org.example;

import org.apache.jasper.JspC;

public class JspToServletConverter {
    public static void convert(String input, String out) {
        try {
            JspC jspC = new JspC();
            jspC.setUriroot(".");
            jspC.setJspFiles(input);
            jspC.setOutputDir(out);
            jspC.setCompile(true);
            jspC.setCompilerTargetVM("1.8");
            jspC.execute();
            System.out.println("JSP compilation completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
