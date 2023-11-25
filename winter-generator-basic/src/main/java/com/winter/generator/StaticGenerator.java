package com.winter.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @program: winter-generator
 * @description: 静态文件生成
 * @author: Mr.Ye
 * @create: 2023-11-21 22:51
 **/
public class StaticGenerator {
	public static void main(String[] args) {
		// 获取项目的根路径
		String rootPath = System.getProperty("user.dir");
		// 拼接源文件路径，使用File.separator可以根据不同的操作系统使用不同的路径分隔符
		String srcPath = rootPath + File.separator + "demo-projects" + File.separator + "acm-template";
		// 拷贝文件
		doGenerateByHutool(srcPath, rootPath);
	}

	private static void doGenerateByHutool(String srcPath, String destPath) {
		FileUtil.copy(srcPath, destPath, false);
	}
}
