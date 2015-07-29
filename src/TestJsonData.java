import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

import org.bouncycastle.util.encoders.Base64Encoder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jcifs.Config;


public class TestJsonData {

	public TestJsonData() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]){
		try {
			JsonObject mJsonObject = new JsonObject();
//			mJsonObject.addProperty("deviceId", "353627051653460");
//			mJsonObject.addProperty("mobile", "18310665040");
//			mJsonObject.addProperty("provCode", "650000");
		    String mBaseKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDosvH1gCpQTTZLXGMcSeeqDjWuDVY0+Aab1VbtGJqWdkPd32D4hEUwFjVJ+FJbq7UpvFFDQ3k2y2n/1rzxWapFk/e+BNNCSKP9e6+Of1SLs83So27dgiAeAKmdQoxwfXrgvP1/QRMJJ0i6m3CRRyTlXO+cMGbYqRv1iTT9uaRolQIDAQAB";
			String key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJy%2F0qbJRZK89%2B0wQHOQ2N14mqxlzaUSQP9%2BJ2RCU0zdevUPJChh%2BbswDnhphJYZImGE4%2BWa7rtg4OOdfP9vun2IT%2F7lGnHLxbUHVpwocrrjqmqzEwOHPvCOPxtJFD6qFG1fVZkyylWduGL%2FpkHLgto%2FAcKKnuyPLUYAr3NrWmBTAgMBAAECgYAXEPNCr%2BOZEE27jZouZ2ZCUPkR3XlBjUobTsklK81uRjlNzoiXmLNTJGM8vOpR3Cj%2FCLswkngHAt6VIBvAywQ6MSCHSZvhRfm4PnIsPj6XF8hZjx4MG5nez7DmrO6z6se0Ibxm86jjvGn%2BNbY7vwPyI2ZJA852rZD057zR7kb%2FAQJBAOp%2BRMI%2FD%2BM15Vdrjav9nlWDdUJkJetkOaYTGJCOPObFvxVeiBkuisGVmCbKXSSFjbaD95Buq%2F1XqphzE4fq3HMCQQCrIC7gn2ugtGJsbgLmxk3Cg4MZM4FLbG%2BDM84c7uPjELNY7BysCPYlkQszNNVUSIzKGXEX7seGDuDvyCtacFShAkEAkAbAOsK7AmYvGBOyb4oV%2FxYAJqgWdk8X7X5bHyaOF3wr0nc%2BhqEEjsRQMLsonG7%2FTLQfkXG4Z6G54WsE%2Bv1xKwJAb%2FkgE2TdZQuDd5XImj7Z9NRe%2FSeBi9vJX92PGcmLHjH4WNAutrcqcUxmOrxwdrT%2BQuPA57sbnXGw59Vf4M6t4QJBAIZFVG6%2BBj%2FCqxn64mtLDN86%2FZQbFfXlKXvXxmAlN6s9ACbDycYL7mJheK%2F8mDoIVgHoa8yTKdO5%2BgRvVIaFEvE%3D";
		
			//System.out.println(Base64.getDecoder().decode(URLDecoder.decode(key,"utf-8")));
			//加密json对象
			Gson mGson = new Gson();
			String json = mGson.toJson(mJsonObject);
			System.out.println(json);
			String encript = RSAUtils.encryptByPrivateKey(json, key);
			System.out.println(encript);
			String sign = RSAUtils.sign(encript, key);//对加密后数据进行签名
			System.out.println(sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
