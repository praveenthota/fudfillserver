package com.fudfil.edelivery.location.service;

import org.springframework.stereotype.Service;

import com.fudfil.edelivery.common.EDeliveryBusinessException;
import com.fudfil.edelivery.common.EDeliverySystemException;
import com.fudfil.edelivery.common.RunnerView;
import com.fudfil.edelivery.request.LocationUpdateReq;

@Service
public interface ILocationService {

	public boolean updateLocation(LocationUpdateReq locReq)
			throws EDeliveryBusinessException, EDeliverySystemException;

	public RunnerView getRunnerLocation(String userId)
			throws EDeliveryBusinessException, EDeliverySystemException;;

}
