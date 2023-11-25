package com.winter;

import com.winter.cli.CommandExecutor;

/**
 * @program: winter-generator
 * @description: 客户端调用类
 * @author: Mr.Ye
 * @create: 2023-11-25 22:54
 **/
public class MainClient {
	public static void main(String[] args) {
		// args = new String[]{"generate","-l", "-a", "-o"};
		// args = new String[]{"list"};
		// args = new String[]{"config"};
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.doExecute(args);
	}
}
