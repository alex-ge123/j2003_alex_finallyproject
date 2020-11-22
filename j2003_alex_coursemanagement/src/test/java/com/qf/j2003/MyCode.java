package com.qf.j2003;

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

import java.util.ArrayList;

// 代码生成器
public class MyCode {

    public static void main(String[] args) {
       //  构建代码生成器对象
        AutoGenerator autoCode = new AutoGenerator();
        // 配置策略
        // 1，全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setOutputDir(projectPath+"/j2003_leen_order_model/src/main/java");
        // config.setAuthor("");  // 作者名字
        config.setOpen(false);  // 是否打开资源管理器
        config.setFileOverride(false); // 是否覆盖之前的内容
        config.setServiceName("%sService") ;  // 去除service 的I 前缀
        config.setIdType(IdType.ID_WORKER);
        config.setDateType(DateType.ONLY_DATE); // 日期类型
        config.setSwagger2(true) ;

        autoCode.setGlobalConfig(config);

        // 2，设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://10.12.153.77:3306/education?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("ROOT");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoCode.setDataSource(dataSourceConfig);

        // 3，包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("order");
        packageConfig.setParent("com.qf.j2003");
        packageConfig.setEntity("pojo");
        packageConfig.setController("controller");
        packageConfig.setMapper("mapper") ;
        packageConfig.setService("service");
        autoCode.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("tb_teacher");  // 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel); // 下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);  // 自动lombok
        // strategy.setRestControllerStyle(true);  // 链式编程

        strategy.setLogicDeleteFieldName("deletestatus");  // 逻辑删除字段
        // 自动填充配置
        TableFill created = new TableFill("create_time", FieldFill.INSERT); // 自动填充
        TableFill update = new TableFill("update_time", FieldFill.INSERT_UPDATE);  // 修改填充
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(created);
        tableFills.add(update);
        strategy.setTableFillList(tableFills);

        // 乐观锁
        // strategy.setVersionFieldName("deletestatus");
        strategy.setRestControllerStyle(true);

        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); // 改变链接请求

        autoCode.setStrategy(strategy);


        autoCode.execute();
   }


}