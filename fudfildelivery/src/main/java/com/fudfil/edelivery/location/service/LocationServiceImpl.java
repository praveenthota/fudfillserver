package com.fudfil.edelivery.location.service;

import com.fudfil.edelivery.common.EDeliveryBusinessException;
import com.fudfil.edelivery.common.EDeliverySystemException;
import com.fudfil.edelivery.common.RunnerView;
import com.fudfil.edelivery.request.LocationUpdateReq;

public class LocationServiceImpl implements ILocationService {
	LocationUpdateReq mLocReq = null;

	public boolean updateLocation(LocationUpdateReq locReq)
			throws EDeliveryBusinessException, EDeliverySystemException {
		// TODO Auto-generated method stub
		mLocReq = locReq;
		return true;
	}

	public RunnerView getRunnerLocation(String userId)
			throws EDeliveryBusinessException, EDeliverySystemException {
		// TODO Auto-generated method stub
		if (mLocReq != null) {
			RunnerView tRunner = new RunnerView();
			tRunner.setEmailId(mLocReq.getEmailId());
			tRunner.setFirstName("Praveen");
			tRunner.setLastName("Thota");
			tRunner.setLocation(mLocReq.getLocation());
			tRunner.setContactNumber("9886991250");
			return tRunner;
		}
		return null;
	}

}
