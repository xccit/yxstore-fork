import io.xccit.store.generator.CodeGenerator;

/**
 * @author CH_ywx
 * @date 2023-06-17
 * @description
 */
public class Generator {
    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator(
                "E:\\IdeaProjects\\yxstore-master\\store-service\\service-activity",
                "xccit-dev",
                "jdbc:mysql://localhost:3306/shequ-activity?useSSL=false&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8",
                "root","1209","io.xccit.store","activity"
        );
        codeGenerator.generator("activity_info","activity_rule","activity_sku","coupon_info","coupon_range","coupon_use");
    }
}
