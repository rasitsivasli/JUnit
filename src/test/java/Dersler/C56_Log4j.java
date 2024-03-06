package Dersler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C56_Log4j {
    //    onemli olan burada log4j mesaj seviyeleri..
    //    All  – Günlük kaydı düzeyip her şeyi günlüğe kaydeder. (Tüm günlükleri açar)
    //    DEBUG – Hata ayıklama bilgilerini yazdırır ve geliştirme aşamasında yardımcı olur.
    //    INFO – Uygulamanın ilerleyişini vurgulayan bilgi mesajı yazdırır.
    //    WARN – Hatalı ve beklenmeyen sistem davranışıyla ilgili bilgileri yazdırır.
    //    ERROR – Sistemin devam etmesine izin verebilecek bir hata mesajı yazdırır.
    //    FATAL – Uygulamanın çökmesine neden olan sistemin kritik bilgilerini yazdırır.
    //    OFF – Kayıt yok.


    public static void main(String[] args){
        Logger logger = LogManager.getLogger();

        logger.trace("bu bir trace mesajidir");//trace
        logger.debug("bu bir debug mesajidir");//debug
        logger.info("bu bir info mesajidir");//info
        logger.warn("bu bir warn mesajidir");//warn
        logger.error("bu bir error mesajidir");//error
        logger.fatal("bu bir fatal mesajidir");//fatal

    }
    //logger ile configurasyon olmadan sadece
    //ERROR C2_Log4j bu bir error mesajidir
    //FATAL C2_Log4j bu bir fatal mesajidir
    //yukardaki ciktilari alabilirz..bunu duzenlemek icin konfigurrasyon yapmaliyiz..
}
