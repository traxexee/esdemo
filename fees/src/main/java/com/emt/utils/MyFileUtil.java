package com.emt.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:35 2018/6/1.
 * @Modified By:
 */
@Slf4j
public class MyFileUtil {
    /**
     * 判断文件是否存在
     *
     * @param strFile
     * @return
     */
    public static boolean fileIsExists(String strFile) {
        try {
            File f = new File(strFile);
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 读取文件为String
     *
     * @param fileName
     * @return
     */
    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读取文件某行的内容
     *
     * @param pathName
     * @param lineNumber
     * @throws IOException
     */

    public static String readOneLine(String pathName, int lineNumber) throws IOException {
        File file = new File(pathName);//文件路径
        FileReader fileReader = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(fileReader);
        int number = lineNumber;//设置指定行数
        String txt = "";
        int lines = 0;
        while (txt != null) {
            lines++;
            txt = reader.readLine();
            if (lines == number) {
                log.info("第" + reader.getLineNumber() + "的内容是：" + txt + "\n");
                break;
            }
        }
        reader.close();
        fileReader.close();
        return txt;
    }

    public static void main(String[] args) {

        System.out.println(fileIsExists("D:/a.txt"));
        File file = new File("D:/a.txt");
        System.out.println(fileIsExists("D:/a.txt"));
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileIsExists("D:/a.txt"));
    }
}
