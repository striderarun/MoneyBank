package com.papa.bank.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.papa.bank.domain.User;
import com.papa.bank.dto.StatusDTO;
import com.papa.bank.dto.UserDetailsDTO;
import com.papa.bank.request.TransferRequestBean;
import com.papa.bank.request.UserRequestBean;
import com.papa.bank.service.BankingService;
import com.papa.bank.service.MessagingService;

@Controller
@RequestMapping(value = "/")
public class BankingController {

	@Autowired
	BankingService bankingService;

	@Autowired
	MessagingService messagingService;

	@RequestMapping(value="/")
	public ModelAndView displayLoginPage(HttpServletRequest request){
		String userName = (String)request.getSession().getAttribute("userName");
		if (null != userName) {
			return new ModelAndView("Home");
		} else {
			return new ModelAndView("Login");
		}
	}

	@RequestMapping(value="/dashboard")
	public ModelAndView displayHomePage(HttpServletRequest request){
		String userName = (String)request.getSession().getAttribute("userName");
		if (null != userName) {
			return new ModelAndView("Home");
		} else {
			return new ModelAndView("Login");
		}
	}

	@RequestMapping(value="/transfer")
	public ModelAndView displayTransferPage(HttpServletRequest request){
		String userName = (String)request.getSession().getAttribute("userName");
		if (null != userName) {
			return new ModelAndView("Transfer");
		} else {
			return new ModelAndView("Login");
		}
	}

	@RequestMapping(value="/login" , method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public StatusDTO authenticate(@RequestBody UserRequestBean bean, HttpServletRequest request, HttpServletResponse response){
		StatusDTO statusDTO = null;
		String userName = (String)request.getSession().getAttribute("userName");
		if (null != userName) {
			statusDTO = new StatusDTO();
			statusDTO.setStatusMessage("SUCCESS");
		} else {
			User user = bankingService.authenticateUsers(bean);

			if (null != user) {
				statusDTO = new StatusDTO();
				statusDTO.setStatusMessage("SUCCESS");
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", user.getUserName());
			Cookie cookie = new Cookie("userCookie",user.getUserName());
			response.addCookie(cookie);

		}

		return statusDTO;
	}

	@RequestMapping(value="/getAccountDetails" , method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public UserDetailsDTO getAccountDetails(HttpServletRequest request) {
		String userName = (String)request.getSession().getAttribute("userName");
		return bankingService.getAccountDetails(userName);

	}

	@RequestMapping(value="/transferFunds" , method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public StatusDTO transferFunds(@RequestBody TransferRequestBean transferRequest, HttpServletRequest request) {
		String debitUser = null;
		StatusDTO statusDTO = new StatusDTO();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (null != cookie.getName() && cookie.getName().equals("userCookie")) {
					debitUser = cookie.getValue();
				}
			}
		} else {
			debitUser = (String)request.getSession().getAttribute("userName");
		}
		if (bankingService.transferFunds(transferRequest, debitUser)) {
			statusDTO.setStatusMessage("SUCCESS");
		}
		return statusDTO;
	}

	@RequestMapping(value="/logout")
	public ModelAndView logout() {
		return new ModelAndView("Login");
	}

	@RequestMapping(value="/message", method = RequestMethod.GET)
	public void sendMessage(@RequestParam(value = "message", required = true) final String message) {
		messagingService.sendMessage(message);
	}

	@RequestMapping(value="/messageGateway", method = RequestMethod.GET)
	public void sendMessageGateway(@RequestParam(value = "message", required = true) final String message) {
		String response = messagingService.sendMessageGateway(message);
		System.out.println(response);
	}

}
