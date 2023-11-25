package com.winter.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.*;

import java.io.File;
import java.util.List;

/**
 * @program: winter-generator
 * @description: 查看生成文件类
 * @author: Mr.Ye
 * @create: 2023-11-25 21:51
 **/
@Command(name = "list", version = "winter1.0", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
	@Override
	public void run() {
		String rootPath = System.getProperty("user.dir");
		String sourcePath = rootPath + File.separator + "demo-projects" + File.separator + "acm-template";
		List<File> files = FileUtil.loopFiles(sourcePath);
		for (File file : files) {
			System.out.println(file);
		}
	}

}
