import io.xccit.store.generator.CodeGenerator;

/**
 * @author CH_ywx
 * @date 2023-06-14
 * @description 代码生成
 */
public class Generator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator(
                "E:\\IdeaProjects\\yxstore-master\\store-service\\service-product",
                "xccit-dev",
                "jdbc:mysql://localhost:3306/shequ-product",
                "root","1209","io.xccit.store","product"
        );
        codeGenerator.generator("attr","attr_group","category","sku_info","sku_poster",
                "sku_image","sku_stock_history","sku_detail","sku_attr_value");
    }
}
