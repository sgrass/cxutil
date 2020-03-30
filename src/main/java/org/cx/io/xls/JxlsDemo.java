package org.cx.io.xls;

import org.apache.commons.io.IOUtils;
import org.cx.designpattern.adapter.login.vo.Member;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author grass
 * @date 2019/9/17
 */
public class JxlsDemo {

    public static void main(String[] args) throws IOException {
        List<Member> memberList = new ArrayList<>();
        Member m1 = new Member();
        m1.setUsername("aaaa");
        m1.setPassword("是防守打法");
        m1.setInfo("发个剧3问偶尔看如图8if嫁给他忽然放假没打过热闹");
        memberList.add(m1);

        try(InputStream is = new FileInputStream(JxlsDemo.class.getClassLoader().getResource("jxls_export_template.xlsx").getFile())) {
            try (OutputStream os = new FileOutputStream("/Users/grass/Desktop/aa.xls")) {
                Context context = new Context();
                context.putVar("memberList", memberList);
                context.putVar("stringTest", "随便设置个");
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        }
    }
}
