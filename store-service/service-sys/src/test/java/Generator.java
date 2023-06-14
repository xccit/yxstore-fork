import io.xccit.store.generator.CodeGenerator;

/**
 * @author CH_ywx
 * @date 2023-06-14
 * @description 生成本模块基础层代码
 */
public class Generator {
    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator(
                "E:\\IdeaProjects\\yxstore-master\\store-service\\service-sys",
                "xccit-dev",
                "jdbc:mysql://localhost:3306/shequ-sys",
                "root","1209","io.xccit.store","sys"
        );
        codeGenerator.generator("region","ware","region_ware");
    }
}
