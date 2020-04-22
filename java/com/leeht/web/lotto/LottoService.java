package com.leeht.web.lotto;

import com.leeht.web.util.LottoResult;
public interface LottoService {

	void buy(Lotto lotto);
	int count();
	LottoResult result(String userid);

}
