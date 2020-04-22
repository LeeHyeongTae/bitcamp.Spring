package com.leeht.web.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leeht.web.util.Messenger;
import com.leeht.web.util.LottoResult;

@RestController
@RequestMapping("/lotto")
public class LottoController {
	@Autowired LottoService lottoService;
	
	@PostMapping("/buy")
	public Messenger buy(@RequestBody Lotto lotto) {
		int count = lottoService.count();
		lottoService.buy(lotto);
		return (lottoService.count()==count+1)? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@GetMapping("/result{userid}")
	public LottoResult result(@RequestBody String userid) {
		System.out.println(userid);
		return lottoService.result(userid);
	}

}
