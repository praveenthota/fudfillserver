package com.fudfil.edelivery.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fudfil.edelivery.common.RunnerView;

@Controller
public class FudfillTestController {

	@RequestMapping(value = "/testserver", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<String> get(@RequestParam(value = "file") String fileName,
			HttpServletRequest servReq) {
		ResponseEntity<String> respEntity = null;
		RunnerView runnerLoc = null;
		ServletContext servContext = servReq.getSession().getServletContext();
		String appPath = servContext.getRealPath("");
		String lineSeparator = System.getProperty("file.separator");
		String filePath = appPath + lineSeparator + fileName + ".json";
		try {
			String responseStr = readFile(filePath);
			respEntity = new ResponseEntity<String>(responseStr, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			respEntity = new ResponseEntity<String>(
					"{ \"error\": \"exception\"}", HttpStatus.OK);
			e.printStackTrace();
		}

		return respEntity;
	}

	private String readFile(String pathname) throws IOException {

		File file = new File(pathname);
		StringBuilder fileContents = new StringBuilder((int) file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");

		try {
			while (scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
	}

	@RequestMapping(value = "/updateorder", produces = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	ResponseEntity<String> putorders(HttpServletRequest servReq) {
		ResponseEntity<String> respEntity = null;
		try {
			String responseStr = "{ \"result\": \"success\"}";
			respEntity = new ResponseEntity<String>(responseStr, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			respEntity = new ResponseEntity<String>(
					"{ \"result\": \"exception\"}", HttpStatus.OK);
			e.printStackTrace();
		}

		return respEntity;
	}
}
