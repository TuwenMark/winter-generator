package com.winter.cli.command;

import cn.hutool.core.util.ReflectUtil;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @program: winter-generator
 * @description: 允许用户传入的动态参数配置类
 * @author: Mr.Ye
 * @create: 2023-11-25 21:51
 **/
@Command(name = "config", version = "winter1.0", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
	@Override
	public void run() {
		Field[] fields = ReflectUtil.getFields(GenerateCommand.class);
		for (Field field : fields) {
			System.out.println("参数名称：" + field.getName() + ", 参数类型：" + field.getType().getSimpleName());
		}
	}
}
