package com.leeht.web.lotto;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.leeht.web.util.LottoResult;

@Service
public class LottoServiceImpl implements LottoService {
	private Lotto[] lottos;
	private int count;

	public LottoServiceImpl() {
		lottos = new Lotto[10];
		count = 0;
	}

	@Override
	public void buy(Lotto lotto) {
		lottos[count] = lotto;
		count++;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public LottoResult result(String userid) {
		LottoResult result = null;
		for (int i = 0; i < count; i++) {
			if (userid.equals(lottos[i].userid)) {
				switch (matchCount(lottos[i].lottoNumber)) {
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
		}
		return result;
	}

	private int matchCount(String lottoNumber) {
		int count = 0;
		if(duplicate(lottoNumber)!=null) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (duplicate(lottoNumber)[i] == radomNumbers()[j]) {
					count++;
					}
				}
			}
		}
		return count;
	}

	private int[] duplicate(String lottoNumber) {
		int[] duplicated = new int[6];
		for (int i = 0; i < duplicated.length; i++) {
			duplicated[i] = Integer.parseInt(lottoNumber.split(",")[i]);
		}
		for (int i = 0; i < duplicated.length; i++) {
			for (int j = 1; j < duplicated.length; j++) {
				if (duplicated[i] == duplicated[j]) {
					return duplicated;
				}
			}
		}
		
		return duplicated;
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

}
