package com.kd.util;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <b>Application name:</b> ResourceUtil.java <br>
 * <b>Application describing:项目参数工具类 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 zhursh 版权所有。<br>
 * <b>Company:</b> zhursh <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:zhursh133@sina.com"> zhursh </a>
 * @version V1.0
 */
public class ResourceUtil {

    private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("sysConfig");

    /**
     * 获取session定义名称
     * @return
     */
    public static final String getSessionattachmenttitle(String sessionName) {
        return bundle.getString(sessionName);
    }


    /**
     * 获得请求路径
     * @param request
     * @return
     */
    public static String getRequestPath(HttpServletRequest request) {
        String requestPath = request.getRequestURI() + "?" + request.getQueryString();
        if (requestPath.indexOf("&") > -1) {// 去掉其他参数
            requestPath = requestPath.substring(0, requestPath.indexOf("&"));
        }
        requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
        return requestPath;
    }

    /**
     * 获取配置文件参数
     * @param name
     * @return
     */
    public static final String getConfigByName(String name) {
        return bundle.getString(name);
    }

    public static String getSysPath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        String temp = path.replaceFirst("file:/", "").replaceFirst("WEB-INF/classes/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator).replaceAll("%20", " ");
        return resultPath;
    }

    /**
     * 获取项目根目录
     * @return
     */
    public static String getPorjectPath() {
        String nowpath; // 当前tomcat的bin目录的路径 如
                        // D:\java\software\apache-tomcat-6.0.14\bin
        String tempdir;
        nowpath = System.getProperty("user.dir");
        tempdir = nowpath.replace("bin", "webapps"); // 把bin 文件夹变到 webapps文件里面
        tempdir += "\\"; // 拼成D:\java\software\apache-tomcat-6.0.14\webapps\sz_pro
        return tempdir;
    }

    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        String temp = path.replaceFirst("file:/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    public static String getSystempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getSeparator() {
        return System.getProperty("file.separator");
    }

    public static String getParameter(String field) {
        HttpServletRequest request = ContextHolderUtils.getRequest();
        return request.getParameter(field);
    }

    /**
     * 获取随机码的长度
     * @return 随机码的长度
     */
    public static String getRandCodeLength() {
        return bundle.getString("randCodeLength");
    }

    /**
     * 获取随机码的类型
     * @return 随机码的类型
     */
    public static String getRandCodeType() {
        return bundle.getString("randCodeType");
    }

    /**
     * 获取组织机构编码长度的类型
     * @return 组织机构编码长度的类型
     */
    public static String getOrgCodeLengthType() {
        return bundle.getString("orgCodeLengthType");
    }

}
