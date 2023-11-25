package com.winter.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.winter.generator.MainGenerator;
import com.winter.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.*;

import java.util.concurrent.Callable;

/**
 * @program: winter-generator
 * @description: 生成文件命令
 * @author: Mr.Ye
 * @create: 2023-11-25 21:50
 **/
@Data
@Command(name = "generate", version = "winter1.0", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable {
	@Option(names = { "-a", "--author" }, description = "作者名称", arity = "0..1", interactive = true, echo = true)
	private String author;

	@Option(names = { "-l", "--loop" }, description = "是否循环", arity = "0..1", interactive = true, echo = true)
	private boolean loop;

	@Option(names = { "-o", "--outputText" }, description = "输出文本", arity = "0..1", interactive = true, echo = true)
	private String outputText;


	@Override
	public Object call() throws Exception {
		// 拷贝对象
		MainTemplateConfig dataModel = BeanUtil.copyProperties(this, MainTemplateConfig.class);
		MainGenerator.doGenerate(dataModel);
		return 0;
	}
}
