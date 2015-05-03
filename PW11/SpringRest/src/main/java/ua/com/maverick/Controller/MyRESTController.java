package ua.com.maverick.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.maverick.DataModel.MyData;

@Controller
@RequestMapping(value = "/MyData")
public class MyRESTController {

	@RequestMapping(value="/{time}", method = RequestMethod.GET)
	public @ResponseBody MyData getMyData(
			@PathVariable long time) {
		
		return new MyData(time, "REST GET Call !!!");
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody MyData putMyData(
			@RequestBody MyData md) {
		
		return md;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody MyData postMyData() {
		return new MyData(
			System.currentTimeMillis(), "REST POST Call !!!");
	}

	@RequestMapping(value="/{time}", method = RequestMethod.DELETE)
	public @ResponseBody MyData deleteMyData(
			@PathVariable long time) {
		
		return new MyData(time, "REST DELETE Call !!!");
	}
}