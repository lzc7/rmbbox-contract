/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.core.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author rooseek
 */
public class FileUtils {

    private static final Logger logger = Logger.getLogger(FileUtils.class.getName());
    
    public static final int LINUX = 1;
	
	public static final int WINDOWS = 2;

    /**
     * write input stream to a local file
     *
     * @param inputStream
     * @param filePath
     */
    public static void writeToFile(InputStream inputStream, String filePath) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(filePath));
            int read;
            byte[] bytes = new byte[4096];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 返回文件后缀,如".pdf"
     *
     * @param fileName
     * @return
     */
    public static String fileSuffix(String fileName) {
        int index = StringUtils.lastIndexOf(fileName, ".");
        if (index != -1) {
            String suffix = fileName.substring(index);
            return suffix;
        }
        return "";
    }
    /**
     * 通过文件名删除文件
     * **/
    public static boolean deleteFile(String fileName) {
		File csvFile = new File(fileName);
		if (csvFile.exists()) {
			return csvFile.delete();
		}
		return false;
	}

    /**
     * 生成文件
     * @param response
     * @param id
     * @param fileName 
     */
    public static void  createFile(HttpServletResponse response, byte[] file, String id, String fileName){
    	if(null==file||file.length==0)return;
    	OutputStream output = null;
        InputStream in = null;
        try {
			response.addHeader("Content-Disposition", "inline; filename="+ URLEncoder.encode(fileName.concat(".pdf"), "UTF-8"));
			response.setContentLength(file.length);
			output = response.getOutputStream();
			in = new BufferedInputStream(new ByteArrayInputStream(file));
			int len;
			byte[] buf = new byte[file.length];
			while ((len = in.read(buf)) != -1) {
				output.write(buf, 0, len);
			}
			output.flush();
		} catch (Exception e) {
			logger.log(Level.SEVERE, fileName+"（"+id+":生成失败）", e);
		} finally {
                try {
                    if (null != in)in.close();
                } catch (IOException e) {
                    in = null;
                    logger.log(Level.SEVERE, "资源关闭失败", e);
                }
                try {
                    if (null != output)output.close();
                } catch (IOException e) {
                    output = null;
                    logger.log(Level.SEVERE, "资源关闭失败", e);
                }
        }
    }
    /**
     * 
     * @return
     */
    public static int getServerOSType(){
		int resultCode = 0;
		String osTag = System.getProperty("os.name");
		if(osTag.indexOf("Linux")!=-1||osTag.indexOf("Mac")!=-1){
			resultCode = LINUX;
		}else{
			resultCode = WINDOWS;
		}
		return resultCode ; 
	}
    
    public static String getTmpBaseStorePath(){
		int osType = getServerOSType();
		String basePath = "";
		if(osType == LINUX){
			basePath = File.separator+"tmp";
		}else if(osType == WINDOWS){
			basePath = "c:"+File.separator+"tmp";
		}
		return basePath;
	}

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     */
    public static void deleteDir(File dir){
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                deleteDir(new File(dir, children[i]));
            }
        }
        // 目录此时为空，可以删除
        dir.delete();
    }

    public static void main(String[] args) {
        File file = new File("E:/datafile/2017-11-22");
        deleteDir(file);
    }
}