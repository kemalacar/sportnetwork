package com.sportnetwork.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.sportnetwork.common.model.MobileDevice;
import com.sportnetwork.web.utils.Constants;

@Service
public class NotificationManager extends AbstractManager {

	public void registerDevice(MobileDevice device){

		notificationService.registerDevice(device);

	}
	

	public void unRegisterDevice(String regId){

		notificationService.unRegisterDevice(regId);

	}

	public void sendNotification(MobileDevice device, String userMessage){

		Sender sender = new Sender(Constants.SPORTNETWORK_GOOGLE_APIKEY);
		
		List<String> androidTargets =  new ArrayList<>();
		for (MobileDevice md : notificationService.getRegisteredDevices()) {
			androidTargets.add(md.getRegistrationId());
		}

		// If multiple messages are sent using the same .collapseKey()
		// the android target device, if it was offline during earlier message
		// transmissions, will only receive the latest message for that key when
		// it goes back on-line.
		Message message = new Message.Builder().timeToLive(30).delayWhileIdle(true).addData("price", userMessage).build();

		try {
			// use this for multicast messages.  The second parameter
			// of sender.send() will need to be an array of register ids.
			MulticastResult result = sender.send(message, androidTargets, 1);

			if (result.getResults() != null) {
				int canonicalRegId = result.getCanonicalIds();
				if (canonicalRegId != 0) {
				}
			} else {
				int error = result.getFailure();
				System.out.println("Broadcast failure: " + error);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
