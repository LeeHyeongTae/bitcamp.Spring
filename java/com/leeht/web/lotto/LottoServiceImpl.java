package com.leeht.web.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.leeht.web.util.LottoResult;

@Service
public class LottoServiceImpl implements LottoService {
	private Map<String, Object> lottos;

	public LottoServiceImpl() {
		lottos = new HashMap<>();
	}

	@Override
	public void buy(Lotto lotto) {
		lottos.put(lotto.userid, lotto);
	}

	@Override
	public int count() {
		return lottos.size();
	}

	@Override
	public LottoResult result(String userid) {
		LottoResult result = null;
			if (lottos.containsKey(userid)) {
				switch (0) {
				case 6:
					result = LottoResult.일등;
					break;
				case 5:
					result = LottoResult.이등;
					break;
				case 4:
					result = LottoResult.삼등;
					break;
				case 3:
					result = LottoResult.사등;
					break;
				case 2:
					result = LottoResult.오등;
					break;
				default:
					result = LottoResult.꽝;
					break;
				}
		}
		return result;
	}

	private int matchCount(String lottoNumber) {
		
		return 0;
	}

	private int[] radomNumbers() {
		int[] randoms = new int[6];
		Random random = new Random();
		for (int i = 0; i < randoms.length; i++) {
			randoms[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (randoms[i] == randoms[j]) {
					i--;
				}
			}
		}
		return randoms;
	}

	@Override
	public Lotto detail(String userid) {
		return (Lotto) lottos.get(userid);
	}

}
