package idc.aast.Other;

import idc.aast.edu.activities.Login;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

import android.app.Application;

public class application extends Application {

	    @Override
	    public void onCreate() {
	        super.onCreate();
	        Parse.initialize(this, "F1bFVq1GTfOwmLMQ7MNJHDU1J8HaVRUXkqdaoa5e", "8mr6c1yrrfr8H44HnI3nyxwSuhAq8P1XZU3XFaox");
	        PushService.setDefaultPushCallback(this, Login.class);
	        ParseInstallation.getCurrentInstallation().saveInBackground();
	    
	}
}
