package Dersler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Property;

public class C57_Log4j_UseProperties {
/*  LogManager.getLogger() yöntemiyle Logger nesnesi alınmış ve artık log4j2.xml veya log4j2.properties dosyalarını
    yapılandırmak yerine varsayılan yapılandırmayı kullanır. Bu sayede, ek bir yapılandırma dosyası kullanmak zorunda kalmazsınız.
    */


    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {


        logger.trace("bu bir trace mesajidir");//trace
        logger.debug("bu bir debug mesajidir");//debug
        logger.info("bu bir info mesajidir");//info
        logger.warn("bu bir warn mesajidir");//warn
        logger.error("bu bir error mesajidir");//error
        logger.fatal("bu bir fatal mesajidir");//fatal

        //her calistirdiginizda projenizde logs klasoru altında kayitlari gorebilirsiniz ..
    }
}
