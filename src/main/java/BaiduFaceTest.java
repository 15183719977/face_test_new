
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 人脸对比
 */
public class BaiduFaceTest {

    // 这里填写你自己应用的三项
    public static final String APP_ID = "16751944";
    public static final String API_KEY = "5W53rSvUNgbFjQeIDGULsf2K";
    public static final String SECRET_KEY = "HmQToe8eVzNGxuFSOlZeeXArHG4rUjLI";



    public static void main(String[] args) throws IOException {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        String image1 = "C:\\Users\\Administrator\\Desktop\\图片\\压缩图\\1.jpg";
        String image2 = "C:\\Users\\Administrator\\Desktop\\图片\\压缩图\\2.jpg";


        byte[] b1 = FileUtils.readFileToByteArray(new File(image1));
        byte[] b2 = FileUtils.readFileToByteArray(new File(image2));


        String s1 = Base64Util.encode(b1);
        String s2 = Base64Util.encode(b2);



        MatchRequest req1 = new MatchRequest(s1, "BASE64");
        MatchRequest req2 = new MatchRequest(s2, "BASE64");

        List<MatchRequest> list = Lists.newArrayList();
        list.add(req1);
        list.add(req2);

        JSONObject rs = client.match(list);
        System.out.println(rs.toString(2));

    }

}