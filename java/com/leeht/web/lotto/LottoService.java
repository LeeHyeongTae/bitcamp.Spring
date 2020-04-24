package com.leeht.web.lotto;


import com.leeht.web.util.LottoResult;
public interface LottoService {

	public void buy(Lotto lotto);
	public int count();
	public LottoResult result(String userid);
	public Lotto detail(String userid);

}
