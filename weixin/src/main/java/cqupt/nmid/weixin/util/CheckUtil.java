package cqupt.nmid.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by 罗浩 on 2017/3/15.
 */
public class CheckUtil {
    private static final String token ="weiChat";
    public  static boolean checkSignature(String signature ,String timestamp,String nonce ){
        String[] arr = new String []{token,timestamp,nonce};
        Arrays.sort(arr);

        //生成字符串
        StringBuffer content = new StringBuffer();
        for (int i = 0;i<arr.length;i++){
            content.append(arr[i]);
        }

        //实现sha1加密
        String temp = CheckUtil.getSha1(content.toString());

        return temp.equals(signature);
    }


    //实现对字符串sha1加密
    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    /**
     * description 对sha1加密的测试
     * @param args_
     * @throws Exception
     */
    /*public static void main  (String [] args_) throws Exception{
        String str = "luohao";
        System.out.print(getSha1(str));//172a69e3e3bc3e676ed0878d5e01c5f3141bda60
    }*/
}
