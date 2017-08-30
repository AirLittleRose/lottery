package com.yc.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 流操作工具
 */
public class IoUtil {
	
	
	
	/**
	 * 文件读取的封装
	 * @param file : 要读的文件
	 * @return   byte[]   字节数组
	 * @throws Exception
	 */
	public static byte[] readFile(  File file) throws Exception{
		byte[] buffer=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		BufferedInputStream bis=null;
		try {
			 bis=new BufferedInputStream(  new FileInputStream( file ));
			byte[] bs=new byte[1024];
			int length=-1;
			while(  (length=bis.read(bs, 0, bs.length))!=-1){
				baos.write(bs, 0, length);
			}
			baos.flush();
			buffer= baos.toByteArray();
		} catch (Exception e) {
			LogUtil.error(e);
			throw e;
		} finally{
			if(   bis!=null){
				bis.close();
			}
			if(  baos!=null){
				baos.close();
			}
		}
		return buffer;
	}
	
	/**
	 * 返回文件大小的带单位的表示 <br />
	 * @param fileSize  :文件的大小
	 * @return   :        "100.00G"   "100.00M"   "100.00T"   "100.00K"   "100.00B"
	 */
	public static String genFileSizeString(    double fileSize){
		long basic=1024;
		String result="";
		NumberFormat nf=new DecimalFormat("####.00");  //   #代表如果没有数字，则为空,   0代表没有数字，则以0填充
		//     k    m    g     t    p
		if(   fileSize>(long)Math.pow(basic, 4)){          // Math.pow( a,b)      a^b
			result=    nf.format(  fileSize/Math.pow(basic, 4) )        +" T";
		}else if(  fileSize>(long)Math.pow(basic, 3)){
			result= nf.format(  fileSize/Math.pow(basic, 3) )    +" G";
		}else if(   fileSize>Math.pow(basic, 2)){
			result=     nf.format(  fileSize/Math.pow(basic, 2) )      +" M";
		}else if(   fileSize>basic){
			result=   nf.format(  fileSize/basic )       +" K";
		}else{
			nf=new DecimalFormat("####");
			result =  nf.format(  fileSize )   +" B";
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
//		byte[] bs=IoUtil.readFile(   new File("c:\\key.dat") );
//		String s=new String(    bs );
//		System.out.println(   s );
		
		System.out.println(   IoUtil.genFileSizeString(   1000000000)   );
	}
}
