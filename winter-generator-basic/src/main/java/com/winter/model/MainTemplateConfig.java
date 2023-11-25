package com.winter.model;

import lombok.Data;

/**
 * @program: winter-generator
 * @description: MainTemplate的数据模型
 * @author: Mr.Ye
 * @create: 2023-11-23 07:04
 **/
@Data
public class MainTemplateConfig {

	private String author;

	private String outputText;

	private boolean loop;

}
