package net.somta;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsDynamicClientFactory;
import javax.xml.namespace.QName;

public class WebServiceClient {

    public static void main(String[] args) {
        // 创建动态客户端工厂实例
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();

        try {
            // 使用WSDL URL创建客户端
            Client client = dcf.createClient("http://localhost:7002/card/services/HelloWorld?wsdl");

            // 定义命名空间和方法名（注意检查你的命名空间是否正确）
            QName qname = new QName("http://dao.xcf.digitalchina.com/", "getUser");

            // 参数值
            String xmlStr = "aaaaaaaa";

            // 调用Web服务方法并获取返回结果
            Object[] objects = client.invoke(qname, xmlStr);

            // 打印返回结果
            if (objects != null && objects.length > 0) {
                System.out.println(objects[0].toString());
            } else {
                System.out.println("No response from the web service.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}