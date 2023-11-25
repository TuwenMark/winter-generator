package com.winter.generator;

import cn.hutool.core.io.FileUtil;
import com.winter.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.java.Log;

import java.io.File;
import java.io.FileWriter;

/**
 * @program: winter-generator
 * @description: 动静结合
 * @author: Mr.Ye
 * @create: 2023-11-25 07:47
 **/
@Log
public class MainGenerator {
	public static void main(String[] args) {
		String rootPath = System.getProperty("user.dir");
		String sourcePath = rootPath + File.separator + "demo-projects" + File.separator + "acm-template";
		String templatePath = rootPath + File.separator + "winter-generator-basic" + File.separator + "src/main/resources/templates";
		String targetPath = rootPath + File.separator + "generated-projects";
		String templateName = "MainTemplate.java.ftl";
		// 静态拷贝
		FileUtil.copy(sourcePath, targetPath, true);
		// 动态拷贝
		MainTemplateConfig dataModel = new MainTemplateConfig();
		dataModel.setAuthor("winter");
		dataModel.setOutputText("求和为：");
		dataModel.setLoop(true);
		String dynamicPath = targetPath + File.separator + "acm-template/src/com/winter/acm/MainTemplate.java";
		doGenerate(templatePath, dynamicPath, templateName, dataModel);
	}

	/**
	 * 动态生成文件
	 *
	 * @param templatePath	模版文件路径
	 * @param dynamicPath	动态文件目标路径
	 * @param templateName	模版名称
	 * @param dataModel	模版数据
	 */
	private static void doGenerate(String templatePath, String dynamicPath, String templateName, MainTemplateConfig dataModel) {
		try {
			// 创建配置对象
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
			configuration.setDefaultEncoding("UTF-8");
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			Template template = configuration.getTemplate(templateName);
			FileWriter fileWriter = new FileWriter(dynamicPath);
			template.process(dataModel, fileWriter);
			fileWriter.close();
		} catch (Exception e) {
			log.info("生成动态文件报错，错误信息是：" + e.getMessage());
		}
	}
}
