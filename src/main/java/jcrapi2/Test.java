package jcrapi2;

import org.openapitools.codegen.OpenAPIGenerator;

public class Test {

    public static void main(String[] args) {
        OpenAPIGenerator.main(new String[]{
                "generate",
                "-g",
                "html",
                "-i",
                "src\\main\\resources\\api.yaml",
                "-o",
                "tmp2",
                "-t",
                "c:\\Users\\mlieshoff\\INIT\\Development\\jcrapi2\\src\\main\\resources\\templates\\wsdl-schema"
        });
    }

}
