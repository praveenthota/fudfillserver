package com.fudfil.edelivery.location.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.fudfil.edelivery.common.EDeliveryBusinessException;
import com.fudfil.edelivery.common.EDeliverySystemException;
import com.fudfil.edelivery.common.JSONUtils;
import com.fudfil.edelivery.common.Location;
import com.fudfil.edelivery.common.RunnerView;
import com.fudfil.edelivery.common.SLocation;
import com.fudfil.edelivery.location.service.ILocationService;
import com.fudfil.edelivery.request.LocationUpdateReq;

@Controller
public class LocationController {

	@Autowired
	ILocationService locationService;

	@RequestMapping(value = "/locupdate", method = { RequestMethod.POST,
			RequestMethod.PUT })
	@ResponseBody
	ResponseEntity<String> locationUpdate(
			@RequestParam(value = "userid", required = true) String userid,
			@RequestParam(value = "lati", required = true) String lati,
			@RequestParam(value = "long", required = true) String longi,
			HttpServletRequest servReq, HttpServletResponse resp) {
		ResponseEntity<String> respEntity = null;
		LocationUpdateReq treq = new LocationUpdateReq();
		Location loc = new Location();
		treq.setEmailId(userid);
		loc.setLatitude(Double.parseDouble(lati));
		loc.setLongitude(Double.parseDouble(longi));
		treq.setLocation(loc);
		String test = JSONUtils.getJSONObjStr(treq);

		try {
			locationService.updateLocation(treq);
			respEntity = new ResponseEntity<String>(test, HttpStatus.OK);
		} catch (EDeliverySystemException e) {
			// TODO Auto-generated catch block
			String reason = "{ \"status\": \"failure\", \"reason\" : \""
					+ e.getMessage() + "\"}";
			respEntity = new ResponseEntity<String>(reason, HttpStatus.OK);

		} catch (EDeliveryBusinessException e) {
			String reason = "{ \"status\": \"failure\", \"reason\" : \""
					+ e.getMessage() + "\"}";
			respEntity = new ResponseEntity<String>(reason, HttpStatus.OK);

		}

		return respEntity;
	}

	@RequestMapping(value = "/jlocupdate", method = { RequestMethod.POST,
			RequestMethod.PUT })
	@ResponseBody
	ResponseEntity<String> jlocationUpdate(
			@RequestBody LocationUpdateReq reqEvent, WebRequest req,
			HttpServletRequest servReq, HttpServletResponse resp) {
		ResponseEntity<String> respEntity = null;

		try {
			locationService.updateLocation(reqEvent);
		} catch (EDeliverySystemException e) {
			// TODO Auto-generated catch block
			String reason = "{ \"status\": \"failure\", \"reason\" : \""
					+ e.getMessage() + "\"}";
			respEntity = new ResponseEntity<String>(reason, HttpStatus.OK);

		} catch (EDeliveryBusinessException e) {
			String reason = "{ \"status\": \"failure\", \"reason\" : \""
					+ e.getMessage() + "\"}";
			respEntity = new ResponseEntity<String>(reason, HttpStatus.OK);

		}

		return respEntity;
	}

	@RequestMapping(value = "/slocupdate", consumes = "application/json", produces = "application/json", method = { RequestMethod.PUT })
	@ResponseBody
	ResponseEntity<String> slocationUpdate(@RequestBody SLocation reqEvent,
			WebRequest req, HttpServletRequest servReq, HttpServletResponse resp) {
		ResponseEntity<String> respEntity = null;

		respEntity = new ResponseEntity<String>(
				JSONUtils.getJSONObjStr(reqEvent), HttpStatus.OK);

		return respEntity;
	}

	@RequestMapping(value = "/locinfo", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<String> get(
			@RequestParam(value = "userid", required = true) String userid,
			HttpServletRequest servReq) {
		ResponseEntity<String> respEntity = null;
		RunnerView runnerLoc = null;
		try {
			String runnerLocStr = null;
			runnerLoc = locationService.getRunnerLocation(userid);
			runnerLocStr = JSONUtils.getJSONObjStr(runnerLoc);
			respEntity = new ResponseEntity<String>(runnerLocStr, HttpStatus.OK);
		} catch (EDeliverySystemException e) {
			// TODO Auto-generated catch block
			String reason = "{ \"status\": \"failure\", \"reason\" : \""
					+ e.getMessage() + "\"}";
			respEntity = new ResponseEntity<String>(reason, HttpStatus.OK);

		} catch (EDeliveryBusinessException e) {
			String reason = "{ \"status\": \"failure\", \"reason\" : \""
					+ e.getMessage() + "\"}";
			respEntity = new ResponseEntity<String>(reason, HttpStatus.OK);

		}

		return respEntity;
	}
}
