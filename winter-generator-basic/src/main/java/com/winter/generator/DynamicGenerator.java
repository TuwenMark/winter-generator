package com.winter.generator;

import com.winter.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: winter-generator
 * @description: 动态文件生成
 * @author: Mr.Ye
 * @create: 2023-11-23 07:05
 **/
public class DynamicGenerator {
	public static void main(String[] args) throws IOException, TemplateException {
		// 创建配置文件
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
		// 设置模版路径
		String templatePath = System.getProperty("user.dir") + File.separator + "winter-generator-basic" + File.separator + "src/main/resources/templates";
		configuration.setDirectoryForTemplateLoading(new File(templatePath));
		// 设置模版字符集
		configuration.setDefaultEncoding("UTF-8");
		// 获取模版
		Template template = configuration.getTemplate("MainTemplate.java.ftl");
		// 设置数据模型
		MainTemplateConfig templateConfig = new MainTemplateConfig();
		templateConfig.setAuthor("winter");
		templateConfig.setOutputText("求和结果为：");
		templateConfig.setLoop(true);
		// 指定输出路径
		FileWriter fileWriter = new FileWriter("MainTemplate.java");
		// 生成文件
		template.process(templateConfig, fileWriter);
		// 关闭流
		fileWriter.close();
	}
}
