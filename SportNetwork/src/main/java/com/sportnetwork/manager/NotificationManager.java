package com.sportnetwork.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.sportnetwork.common.model.MobileDevice;
import com.sportnetwork.common.model.Notification;
import com.sportnetwork.web.utils.Constants;
import com.sportnetwork.web.utils.NotificationSender;

@Service
public class NotificationManager extends AbstractManager {

	public void registerDevice(MobileDevice device){

		deviceService.registerDevice(device);

	}


	public void unRegisterDevice(String regId){

		deviceService.unRegisterDevice(regId);

	}

	public void sendNotification(String regId, String userMessage){



		List<String> regIdList =  new ArrayList<>();
		regIdList.add(regId);

		sendNotification(regId,userMessage);
	}

	public void sendNotification(Notification notification){
		NotificationSender.send(notification);
	}

}
