package lk.ijse.edu.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("${os.name}")
    private String osName;

    @Value("${user.name}")
    private String LOGNAME;

    @Value("${db.name}")
    private String dbName;

    @Value("${db.host}")
    private String dbHost;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.url}")
    private String dbUrl;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
        System.out.println(LOGNAME);
        System.out.println(dbName);
        System.out.println(dbHost);
        System.out.println(dbPassword);
        System.out.println(dbUrl);
    }
}
