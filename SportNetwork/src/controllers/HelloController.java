package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Point;
import model.Venue;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/deneme")
public class HelloController extends AbstractController {

	@RequestMapping(value = "")
	public ModelAndView dene() {
		System.out.println("aa");
		return null;
	}

	@RequestMapping(value = "/test")
	public  void test(@RequestParam String x,HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Venue> list = new ArrayList<Venue>();
		Venue v = new Venue();
		v.setId("asd");
		v.setName("dasdsad");
		v.setPoint(new Point(15, 25));
		
		list.add(v);
		createJSONResponse(response, list);
	}

	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		String str = "Merhaba Spring MVC";
		return new ModelAndView("hello", "mesaj", str);
	}
	
	
	
	
}