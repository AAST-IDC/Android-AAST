package idc.aast.edu.CallWeb;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class CommunityCallSoap {

	public final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ADDRESS = "https://aastmtic.aast.edu/notification/CommunityService.asmx";
	
	//----------------------------------------------------------------------------------------------------
	public final String SOAP_get_groups = "http://tempuri.org/getUserGroups";
	public final String OPERATION_NAME_get_groups = "getUserGroups";
	//------------------------------------------------------------------------------------------
	public final String SOAP_get_groups_posts = "http://tempuri.org/load_posts";
	public final String OPERATION_NAME_get_groups_posts = "load_posts";
	public CommunityCallSoap() {
		// TODO Auto-generated constructor stub
		
	}
	public String get_user_groups(String user_id, String user_type) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME_get_groups);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("user_id");
		pi.setValue(user_id);
		pi.setType(Integer.class);
		request.addProperty(pi);
		p2.setName("user_type");
		p2.setValue(user_type);
		p2.setType(Integer.class);
		request.addProperty(p2);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_get_groups, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	public String get_group_posts(String user_id, String user_type, String group_id, String all_ids) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME_get_groups_posts);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p4 = new PropertyInfo();
		pi.setName("user_id");
		pi.setValue(user_id);
		pi.setType(String.class);
		request.addProperty(pi);
		p2.setName("user_type");
		p2.setValue(user_type);
		p2.setType(String.class);
		request.addProperty(p2);
		
		p3.setName("group_id");
		p3.setValue(group_id);
		p3.setType(String.class);
		request.addProperty(p3);
		
		p4.setName("all_ids");
		p4.setValue(all_ids);
		p4.setType(String.class);
		request.addProperty(p4);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_get_groups_posts, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}

}
