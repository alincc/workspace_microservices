import login.domain.LoginInfo;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chaoj on 2017/3/29.
 */
public class testLogin {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:12345/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        connection.connect();
        //POST请求
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        //登录信息
        LoginInfo li = new LoginInfo();
        li.setPhoneNum("352323");
        li.setPassword("defaultPassword");
        JSONObject obj = new JSONObject(li);
        //写入
        out.write(obj.toString().getBytes("UTF-8"));//这样可以处理中文乱码问题
        out.flush();
        out.close();
        //读取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String lines;
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            sb.append(lines);
        }
        System.out.println(sb);
        reader.close();
        // 断开连接
        connection.disconnect();
    }
}
