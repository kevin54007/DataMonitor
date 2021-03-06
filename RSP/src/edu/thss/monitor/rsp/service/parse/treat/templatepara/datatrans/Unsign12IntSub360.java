package edu.thss.monitor.rsp.service.parse.treat.templatepara.datatrans;

import edu.thss.monitor.rsp.service.parse.treat.templatepara.IDataTrans;

/**
 * 12位无符号整数转换后减40（用于博创协议）
 * @author CaoYuan
 * 2014-3-24
 */
public class Unsign12IntSub360 implements IDataTrans{

	/**
	 * 12位无符号整数转换
	 * 十六进制，低字节在前，高字节在后。例351，解析成0135。再减去360
	 */
	@Override
	public String trans(String value) {
		
		String sub1 = value.substring(0, 8);
		String sub2 = "0000" + value.substring(8);
		String str = sub2 + sub1;
		
		int result = Integer.parseInt(str, 2);
		
		
		return String.valueOf(result-360);
		
	}

}