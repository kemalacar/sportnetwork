package com.sportnetwork.web.utils;

import java.util.List;
import java.util.Map;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.google.android.gcm.server.Message.Builder;
import com.sportnetwork.common.model.Notification;

public class NotificationSender {

	
	public static void send(Notification notification) {

		Sender sender = new Sender(notification.getApiKey());
		
//		List<String> androidTargets =  new ArrayList<>();
//		for (MobileDevice md : deviceService.getRegisteredDevices()) {
//			androidTargets.add(md.getRegistrationId());
//		}

		// If multiple messages are sent using the same .collapseKey()
		// the android target device, if it was offline during earlier message
		// transmissions, will only receive the latest message for that key when
		// it goes back on-line.
		Builder messageBuilder = new Message.Builder().timeToLive(30).delayWhileIdle(true);

		
		for (String key : notification.getMessages().keySet()) {
			messageBuilder.addData(key, notification.getMessages().get(key));
		}
		
		Message message = messageBuilder.build();
		
		try {
			// use this for multicast messages.  The second parameter
			// of sender.send() will need to be an array of register ids.
			MulticastResult result = sender.send(message, notification.getRegIdList(), 1);

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
