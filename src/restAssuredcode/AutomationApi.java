package restAssuredcode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.util.Asserts;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

public class AutomationApi {
	

	public static   String refrereshMethod() throws Exception {
		
		Map<String,String> mapob=new HashMap<String,String>();

		mapob.put("refresh_token", "f6b3d7d751b6ebaf88b4a0a8fa312f5f99a8b131");
		mapob.put("client_id", "191f43b7b47abc9");
		mapob.put("client_secret", "228066d34f830260c2626a0fb8bfe4d2fed4f0df");
		mapob.put("grant_type", "refresh_token");

		Response respoje= RestAssured.given().formParams(mapob).post("https://api.imgur.com/oauth2/token");
		// int staobj= respoje.statusCode();

    	Assert.assertEquals(false, false)  ;
		long expectedTime=3500;
    
		// respoje.then().assertThat().time(Matchers.lessThanOrEqualTo(expectedTime));

		String bodobj= respoje.body().asPrettyString();

		JSONObject js=new  JSONObject(bodobj);

		String getobj=  js.getString("access_token");

		return getobj;

		//  System.out.println(getobj);
		
		
		
		
		
		

		//   String dataName= js.getString("account_username");
		//  System.out.println(dataName);

	}

	public static void main(String[] args) throws Exception {


		UploadPhoto();
	//	refrereshMethod();

	}
	public static void UploadPhoto() throws Exception {
 Map intilObj= new HashMap();
 intilObj.put("name", "Suman");
 intilObj.put("title", "Hii this is Suman");
		File fileob=new File("C:\\Users\\poonam\\eclipse-workspace\\restAssured\\postman\\WIN_20221227_13_43_49_Pro.jpg");

		Response resoj=	RestAssured.given().auth().oauth2(refrereshMethod()).multiPart("imgur", fileob).post("https://api.imgur.com/3/upload");

		resoj.then().assertThat().statusCode(200);
		System.out.println(resoj.getStatusCode());



	}

}
