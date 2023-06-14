package io.xccit.store.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

/**
 * @author CH_ywx
 * @date 2023-06-14
 * @description 代码生成器
 */
@Data
@NoArgsConstructor(force = true)
@ToString
public class CodeGenerator {

    private String projectPath; //项目路径
    private String codePath; //代码生成路径

    private final String author; //作者

    private final String dataSourceUrl; //数据源url

    private final String userName; //数据源username

    private final String password; //数据源password

    private final String packageName; //父包名(本工程默认"io.xccit.store")

    private final String moduleName; //模块名

    private final String tableName; //表名


    public CodeGenerator(String projectPath, String author, String dataSourceUrl, String userName, String password, String packageName, String moduleName,String... tableName) {
        this.projectPath = projectPath;
        this.author = author;
        this.dataSourceUrl = dataSourceUrl;
        this.userName = userName;
        this.password = password;
        this.packageName = packageName;
        this.moduleName = moduleName;
        this.tableName = Arrays.toString(tableName);
        this.codePath = this.projectPath+"/src/main/java";
    }

    public void generator(){
        System.out.println(this);
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(this.codePath);
//        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setAuthor(this.author);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(this.dataSourceUrl);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(this.userName);
        dsc.setPassword(this.password);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(this.packageName);
        pc.setModuleName(this.moduleName); //模块名
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(this.tableName); //数据表
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        mpg.setStrategy(strategy);
        // 6、执行
        mpg.execute();
    }
}
