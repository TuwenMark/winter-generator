import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: winter-generator
 * @description: FreeMarker模版引擎测试类
 * @author: Mr.Ye
 * @create: 2023-11-22 22:31
 **/
public class FreeMarkerTest {

	@Test
	public void test() throws IOException, TemplateException {
		// 创建配置对象
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
		// 设置模版文件所在的路径
		configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
		// 设置模版文件使用的字符集
		configuration.setDefaultEncoding("UTF-8");
		// 创建模版对象，加载指定模版
		Template template = configuration.getTemplate("myweb.html.ftl");
		// 准备数据模型
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("currentYear", 2023);
		List<Map<String, Object>> menuItems = new ArrayList<>();
		Map<String, Object> dataMap1 = new HashMap<>();
		dataMap1.put("url", "https://codefather.cn");
		dataMap1.put("label", "编程导航");
		Map<String, Object> dataMap2 = new HashMap<>();
		dataMap2.put("url", "https://laoyujianli.com");
		dataMap2.put("label", "老鱼简历");
		menuItems.add(dataMap1);
		menuItems.add(dataMap2);
		dataModel.put("menuItems", menuItems);
		// 指定生成的文件
		FileWriter fw = new FileWriter("myweb.html");
		// 生成文件
		template.process(dataModel, fw);
		fw.close();
	}
}
