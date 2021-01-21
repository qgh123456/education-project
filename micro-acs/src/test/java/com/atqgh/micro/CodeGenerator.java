package com.atqgh.micro;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author helen
 * @since 2019/6/24
 */
public class CodeGenerator {

	@Test
	public void genCode() {

		String moduleName = "acs";

		// 1、创建代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 2、全局配置
		GlobalConfig gc = new GlobalConfig();
//		String projectPath = System.getProperty("user.dir");
		String projectPath = "D:\\sdf";
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("Qiguohui");
		gc.setOpen(false); //生成后是否打开资源管理器
		gc.setFileOverride(false); //重新生成时文件是否覆盖
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setServiceName("%sService");	//去掉Service接口的首字母I
		gc.setIdType(IdType.ID_WORKER_STR); //主键策略
		gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
		gc.setSwagger2(true);//开启Swagger2模式

		mpg.setGlobalConfig(gc);

		// 3、数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
//		dsc.setUrl("jdbc:mysql://localhost:3306/guli_" + moduleName + "_190105");
		dsc.setUrl("jdbc:mysql://47.98.136.239:3310/my_project");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");
		dsc.setDbType(DbType.MYSQL);
		mpg.setDataSource(dsc);

		// 4、包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(moduleName); //模块名
		pc.setParent("com.atqgh.micro");
		pc.setController("controller");
		pc.setEntity("entity");
		pc.setService("service");
		pc.setMapper("mapper");
		mpg.setPackageInfo(pc);

		// 5、策略配置
		StrategyConfig strategy = new StrategyConfig();
//		strategy.setInclude("acl_" + moduleName + "_\\w*");//设置要映射的表名
		strategy.setInclude("test" + "_\\w*");//设置要映射的表名
		strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//		strategy.setTablePrefix("t_" + pc.getModuleName() + "_");//设置表前缀不生成
		strategy.setTablePrefix("test" + "_");//设置表前缀不生成
		//strategy.setFieldPrefix("teacher_");//设置列前缀不生成

		strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
		strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

		strategy.setLogicDeleteFieldName("del_flag");//逻辑删除字段名
//		strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀

		//自动填充
//		TableFill createTime = new TableFill("create_date", FieldFill.INSERT);
//		TableFill updateTime = new TableFill("update_date", FieldFill.INSERT_UPDATE);
		TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
		TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
		ArrayList<TableFill> tableFills = new ArrayList<>();
		tableFills.add(createTime);
		tableFills.add(updateTime);
		strategy.setTableFillList(tableFills);

//		strategy.setVersionFieldName("version");//乐观锁列 在version字段前加上@Version注解

		strategy.setRestControllerStyle(true); //restful api风格控制器
		strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

		mpg.setStrategy(strategy);

		// 6、执行
		mpg.execute();
	}
}
