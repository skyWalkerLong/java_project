package zip;

import io.netty.util.CharsetUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 压缩字符串
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-08-30
 */
public class ZipTest {

    public static void main(String[] args) {
        String s = "你不知道我为什么离开你，你坚持不能说放任我哭泣,你不知道我为什么离开你，你坚持不能说放任我哭泣,你不知道我为什么离开你，你坚持不能说放任我哭泣" +
                ",你不知道我为什么离开你，你坚持不能说放任我哭泣,你不知道我为什么离开你，你坚持不能说放任我哭泣,你不知道我为什么离开你，你坚持不能说放任我哭泣";
        System.out.println(s.length());
        String s1 = zipString(s);
        System.out.println("after zip:" + s1);
        System.out.println(s1.length());
        System.out.println(unzipString(s1));
    }

    public static String zipString(String str) {
        try {
            ByteArrayOutputStream bos = null;
            GZIPOutputStream os = null;
            byte[] bs = null;
            try {
                bos = new ByteArrayOutputStream();
                os = new GZIPOutputStream(bos);
                os.write(str.getBytes());
                os.close();
                bos.close();
                bs = bos.toByteArray();
                System.out.println("bs:" + bs);
                return new String(bs, CharsetUtil.ISO_8859_1);
            } finally {
                bs = null;
                bos = null;
                os = null;
            }
        } catch (Exception ex) {
            return str;
        }
    }

    public static String unzipString(String str) {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        GZIPInputStream is = null;
        byte[] buf = null;
        try {
            bis = new ByteArrayInputStream(str.getBytes(CharsetUtil.ISO_8859_1));
            bos = new ByteArrayOutputStream();
            is = new GZIPInputStream(bis);
            buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            is.close();
            bis.close();
            bos.close();
            return new String(bos.toByteArray());
        } catch (Exception ex) {
            return str;
        } finally {
            bis = null;
            bos = null;
            is = null;
            buf = null;
        }
    }
}
