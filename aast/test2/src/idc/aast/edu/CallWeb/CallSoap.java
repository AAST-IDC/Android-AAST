/*
 * 
 */
package idc.aast.edu.CallWeb;

import idc.aast.edu.activities.Login;

import org.ksoap2.SoapEnvelope;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.R.integer;
import android.annotation.TargetApi;

// TODO: Auto-generated Javadoc
// this class is responsible of the connection with the webwervice with all its actions
/**
 * The Class CallSoap.
 */
@TargetApi(10)
public class CallSoap {

	/** The soap action. */
	public final String SOAP_ACTION = "http://tempuri.org/auth_new";

	/** The operation name. */
	public final String OPERATION_NAME = "auth_new";
	
	/** The SOA p_ actio n2. */
	public final String SOAP_ACTION2 = "http://tempuri.org/CheckVersion";

	/** The OPERATIO n_ nam e2. */
	public final String OPERATION_NAME2 = "CheckVersion";

	/** The SOA p_ actio n3. */
	public final String SOAP_ACTION3 = "http://tempuri.org/markAsread";

	/** The OPERATIO n_ nam e3. */
	public final String OPERATION_NAME3 = "markAsread";
	
	/** The SOA p_ actio n4. */
	public final String SOAP_ACTION4 = "http://tempuri.org/markAsUnRead";

	/** The OPERATIO n_ nam e4. */
	public final String OPERATION_NAME4 = "markAsUnRead";

	/** The SOA p_ actio n5. */
	public final String SOAP_ACTION5 = "http://tempuri.org/remove";

	/** The OPERATIO n_ nam e5. */
	public final String OPERATION_NAME5 = "remove";

	/** The SOA p_ actio n6. */
	public final String SOAP_ACTION6 = "http://tempuri.org/get_latest_notifcations2";

	/** The OPERATIO n_ nam e6. */
	public final String OPERATION_NAME6 = "get_latest_notifcations2";

	/** The wsdl target namespace. */
	public final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

	/** The soap address. */
	public final String SOAP_ADDRESS = "https://aastmtic.aast.edu/notification/";

	/** The SOA p_ actio n7. */
	public final String SOAP_ACTION7 = "http://tempuri.org/getall";

	/** The OPERATIO n_ nam e7. */
	public final String OPERATION_NAME7 = "getall";

	/** The SOA p_ actio n8. */
	public final String SOAP_ACTION8 = "http://tempuri.org/auth";

	/** The OPERATIO n_ nam e8. */
	public final String OPERATION_NAME8 = "auth";

	/** The SOA p_ actio n9. */
	public final String SOAP_ACTION9 = "http://tempuri.org/getlinks";

	/** The OPERATIO n_ nam e9. */
	public final String OPERATION_NAME9 = "getlinks";
	
	public final String SOAP_ACTION91 = "http://tempuri.org/get_df_links";

	/** The OPERATIO n_ nam e9. */
	public final String OPERATION_NAME91 = "get_df_links";
	/** The SOA p_ actio n10. */


	

	/** The SOA p_ actio n11. */
	public final String SOAP_ACTION11 = "http://tempuri.org/getcounts";

	/** The OPERATIO n_ nam e11. */
	public final String OPERATION_NAME11 = "getcounts";
	
	
	public final String SOAP_ACTION92 = "http://tempuri.org/get_student_result";

	/** The OPERATIO n_ nam e11. */
	public final String OPERATION_NAME92 = "get_student_result";
	
	
	public final String SOAP_ACTION94 = "http://tempuri.org/get_student_scheduele";

	/** The OPERATIO n_ nam e11. */
	public final String OPERATION_NAME94 = "get_student_scheduele";
	
	public final String SOAP_ACTION95 = "http://tempuri.org/get_news2";

	/** The OPERATIO n_ nam e11. */
	public final String OPERATION_NAME95 = "get_news2";
	
	public final String SOAP_ACTION96 = "http://tempuri.org/get_std_photo";

	/** The OPERATIO n_ nam e11. */
	public final String OPERATION_NAME96 = "get_std_photo";
	
	/**
	 * Instantiates a new call soap.
	 */
	public CallSoap() {
	}

	/**
	 * Gets the type.
	 *
	 * @param a the a
	 * @return the string
	 */
	
	
	public String getlinks_morasalast(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME91);
		PropertyInfo pi = new PropertyInfo();
	//	PropertyInfo p2 = new PropertyInfo();
		pi.setName("empid");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION91, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	public String get_scheduele(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME94);
		PropertyInfo pi = new PropertyInfo();
	//	PropertyInfo p2 = new PropertyInfo();
		pi.setName("user_name");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION94, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	
	public String get_news(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME95);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("last_date");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
		p2.setName("lang");
		p2.setValue(Integer.parseInt(b));
		p2.setType(Integer.class);
		request.addProperty(p2);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
 
		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION95, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	
	
	public String getresults(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME92);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("user_name");
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);
		p2.setName("check");
		p2.setValue(b);
		p2.setType(String.class);
		request.addProperty(p2);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION92, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	public String get_image(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME96);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("user_name");
		pi.setValue(a);
		pi.setType(String.class);
		request.addProperty(pi);
		p2.setName("user_type");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION96, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	
	public String GetType(String a) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME7);
		PropertyInfo pi = new PropertyInfo();
	//	PropertyInfo p2 = new PropertyInfo();
		pi.setName("serial");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION7, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "none";
		}
		return response.toString();
	}

	/**
	 * Call2.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public String Call2(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME2);
		PropertyInfo pi = new PropertyInfo();

		pi.setName("versionNum");
		pi.setValue(Login.version);
		pi.setType(Integer.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION2, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "ERROR";
		}
		return response.toString();
	}

	/**
	 * Read.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public String read(String a, String b,String d) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME3);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3= new PropertyInfo();
		pi.setName("serial");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
	
		p2.setName("user_name");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);

		
		p3.setName("type");
		p3.setValue(d);
		p3.setType(Integer.class);
		request.addProperty(p3);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION3, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0";
		}
		return response.toString();
	}

	/**
	 * Gets the all.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the all
	 */
	public String getall(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME6);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("user_name");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
		p3.setName("user_type");
		p3.setValue(b);
		p3.setType(Integer.class);
		request.addProperty(p3);
		p2.setName("serial");
		p2.setValue(0);
		p2.setType(Integer.class);
		request.addProperty(p2);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION6, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0";
		}
		return response.toString();
	}

	/**
	 * Unread.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public String unread(String a, String b,String d) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME4);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3= new PropertyInfo();
		pi.setName("serial");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
	
		p2.setName("user_name");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);

		
		p3.setName("type");
		p3.setValue(d);
		p3.setType(Integer.class);
		request.addProperty(p3);	
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION4, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0";
		}
		return response.toString();
	}

	/**
	 * Removes the.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public String remove(String a, String b,String d) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME5);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3= new PropertyInfo();
		pi.setName("serial");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
	
		p2.setName("user_name");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);

		
		p3.setName("type");
		p3.setValue(d);
		p3.setType(Integer.class);
		request.addProperty(p3);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION5, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0";
		}
		return response.toString();
	}

	/**
	 * Call.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public String Call(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("UserName");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
		p2 = new PropertyInfo();
		p2.setName("pass");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS,2000);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION, envelope);
			
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0";
		}
		return response.toString();
	}

	/**
	 * Calls.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	public String Calls(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME8);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("UserName");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
		p2 = new PropertyInfo();
		p2.setName("pass");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION8, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0";
		}
		return response.toString();
	}

	/**
	 * Gets the links.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the links
	 */
	public String getlinks(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME9);
		PropertyInfo pi = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		pi.setName("empid");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);
		p2.setName("type");
		p2.setValue(b);
		p2.setType(Integer.class);
		request.addProperty(p2);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		
		try {
			httpTransport.call(SOAP_ACTION9, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "error";
		}
		return response.toString();
	}
	
	/**
	 * Gets the settings.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the settings
	 */

	
	/**
	 * Gets the counts.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the counts
	 */
	public String getcounts(String a, String b) {
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
				OPERATION_NAME11);
		PropertyInfo pi = new PropertyInfo();
	//	PropertyInfo p2 = new PropertyInfo();
		pi.setName("empid");
		pi.setValue(a);
		pi.setType(Integer.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try {
			httpTransport.call(SOAP_ACTION11, envelope);
			response = envelope.getResponse();

		} catch (Exception exception) {
			response = exception.toString();
			response = "0^0^0^0";
		}
		return response.toString();
	}
	
}