package jeff.bix.account.controller;

import jeff.bix.account.model.Account;
import jeff.bix.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountSer;
	

	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("list", "list");
		
		return "hello";
	}
	
	@RequestMapping(value = "/listAllAccounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> listAllAccounts() {
		List<Account> customerList = accountSer.listAllAccount();
		return ResponseEntity.ok().body(customerList);
	}
	

	
	
	@RequestMapping(value = "/delAccount/{account}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delAccount(Model model, @PathVariable("account") String account) {
		accountSer.delAccount(account);
		return ResponseEntity.ok().body("Delete successfully");
	}



	/**
	 *
	 * Test Data as below
	 {
	 "id": 5,
	 "account": "account5",
	 "pwdHash": "$2a$10$bHw13zr6a2S6SAT19DVzo.WO3qZCOSr89SS2pDpGev2EOj7EIJQTu",
	 "user": {
	 "id": 1,
	 "name": "user_name",
	 "gender": "M",
	 "birthday": "1980-01-01",
	 "uType": "CUSTOMER"
	 },
	 "balance": 200.55,
	 "accountState": "ACTIVE",
	 "lastUpdateDate": "2022-01-16",
	 "lastUpdateProcess": "BK",
	 "lastUpdateUser": 3,
	 "createDate": "2022-01-16",
	 "createUser": 3
	 }
	 *
	 * **/


	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public ResponseEntity<String> addAccount(HttpServletRequest request, @RequestBody Account account) {
		accountSer.createAccount(account);
		return ResponseEntity.ok().body("Created successfully");
	}
	
}
