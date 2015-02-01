package com.fudfil.edelivery.location.dao;

import org.springframework.stereotype.Repository;

import com.fudfil.edelivery.request.LocationUpdateReq;

@Repository
public interface ILocationDao {

	public boolean updateLocation(LocationUpdateReq locReq);

	public boolean getLocation(String userId);
}
