package com.zipi.utils;

import java.io.*;

public class FileUtil
{
  public static byte[] readFile(InputStream inStream)
  {
//    File f = new File(filename);
//    if (!f.exists()) {
//      return null;
//    }

//    ByteArrayOutputStream bos = new ByteArrayOutputStream((int)f.length());
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    BufferedInputStream in = null;
    try {
//      in = new BufferedInputStream(new FileInputStream(f));
      in = new BufferedInputStream(inStream);
      int buf_size = 1024;
      byte[] buffer = new byte[buf_size];
      int len = 0;
      while (-1 != (len = in.read(buffer, 0, buf_size))) {
        bos.write(buffer, 0, len);
      }
      return bos.toByteArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        bos.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] getBytesFromFile(File f) throws Exception {
      FileInputStream fileInputStream = null;
      try {
          fileInputStream = new FileInputStream(f);
          byte[] b = new byte[fileInputStream.available()];
          fileInputStream.read(b);
          return b;
      } catch (Exception e) {
          throw e;
      } finally {
          try {
              if (fileInputStream != null) {
                  fileInputStream.close();
              }
          } catch (IOException e) {
          }
      }

  }
  public static void wirteDataToFile(String savePath,byte[] data) throws Exception{
      FileOutputStream fileOutputStream=null;
      try {
          fileOutputStream = new FileOutputStream(savePath);
          fileOutputStream.write(data);
          fileOutputStream.flush();
      } catch (Exception e) {
          throw e;
      } finally {
          try {
              if (fileOutputStream != null) {
                  fileOutputStream.close();
              }
          } catch (IOException e) {
          }
      }
  }
  
  public  boolean createDirectory(String descDirName) {
	  String templateFile = new File("").getAbsolutePath();
		//windows下
		if("\\".equals(File.separator)){
			templateFile = templateFile.substring(0,templateFile.indexOf("\\"));
			templateFile = templateFile.replace("/", "\\");
		}
		//linux下
		if("/".equals(File.separator)){
			templateFile = templateFile.substring(0,templateFile.indexOf("/"));
			templateFile = templateFile.replace("\\", "/");
		} 
	  
		String descDirNames = templateFile+File.separator+"data"+File.separator+"sealfile"+File.separator+descDirName;
		if (!descDirNames.endsWith(File.separator)) {
			descDirNames = descDirNames + File.separator;
		}
		File descDir = new File(descDirNames);
		if (descDir.exists()) {
			return false;
		}
		// 创建目录
		if (descDir.mkdirs()) {
			return true;
		} else {
			return false;
		}

	}
}