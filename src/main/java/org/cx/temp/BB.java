package org.cx.temp;

import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaMetadataKeys;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author grass
 * @date 2019/2/24
 */
public class BB {
    public static void main(String[] args) {
//        System.out.println(new BB().getClass().getClassLoader());
//        System.out.println(new Object().getClass().getClassLoader());


//        Map map = new HashMap<String, String>();
//        map.put("aa","aa");
//        map.put("bb","bb");
//        map.get("aa");


//        String regex="http(s)?://(((.*\\.)*(kakamobi|mucang|jiakaobaodian|tufu|maichebao|jiaxiaozhijia)\\.(com|cn|net.cn).*)|(192\\.168\\..*)|localhost.*|127\\.0\\.0\\.1.*)";
//        boolean flag = Pattern.matches(regex, "http://a.maichebao.net.cn");
//        System.out.println(flag);

        boolean flag = false;
        System.out.println((flag &= true));

    }
}
