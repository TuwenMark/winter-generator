package com.winter.cli;

import com.winter.cli.command.ConfigCommand;
import com.winter.cli.command.GenerateCommand;
import com.winter.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @program: winter-generator
 * @description: 命令执行类
 * @author: Mr.Ye
 * @create: 2023-11-25 21:53
 **/
@Command(name = "winter", version = "winter1.0", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{
	private CommandLine commandLine;

	{
		commandLine = new CommandLine(this)
				.addSubcommand(new GenerateCommand())
				.addSubcommand(new ListCommand())
				.addSubcommand(new ConfigCommand());
	}

	@Override
	public void run() {
		// 不输入子命令时，给出友好提示
		System.out.println("请输入具体命令，或者输入--help查看命令提示");
	}

	public Integer doExecute(String[] args) {
		return commandLine.execute(args);
	}
}
