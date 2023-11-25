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
		// 模版数据
		MainTemplateConfig dataModel = new MainTemplateConfig();
		dataModel.setAuthor("winter");
		dataModel.setOutputText("求和为：");
		dataModel.setLoop(true);
		// 生成文件
		doGenerate(dataModel);
	}

	/**
	 * 生成文件
	 *
	 * @param dataModel	模版数据
	 */
	public static void doGenerate(MainTemplateConfig dataModel) {
		try {
			String rootPath = System.getProperty("user.dir");
			String sourcePath = rootPath + File.separator + "demo-projects" + File.separator + "acm-template";
			String templatePath = rootPath + File.separator + "winter-generator-basic" + File.separator + "src/main/resources/templates";
			String targetPath = rootPath + File.separator + "generated-projects";
			String templateName = "MainTemplate.java.ftl";
			// 静态拷贝
			FileUtil.copy(sourcePath, targetPath, true);
			// 创建配置对象
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
			configuration.setDefaultEncoding("UTF-8");
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			Template template = configuration.getTemplate(templateName);
			String dynamicPath = targetPath + File.separator + "acm-template/src/com/winter/acm/MainTemplate.java";
			FileWriter fileWriter = new FileWriter(dynamicPath);
			template.process(dataModel, fileWriter);
			fileWriter.close();
		} catch (Exception e) {
			log.info("生成动态文件报错，错误信息是：" + e.getMessage());
		}
	}
}
