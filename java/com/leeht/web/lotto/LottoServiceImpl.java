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
		for(int i=0; i<count; i++) {
			if(userid.equals(lottos[i].userid)) {
				switch(matchCount(lottos[i].lottoNumber)) {
				case 6: result=LottoResult.일등; break;
				case 5: result=LottoResult.이등; break;
				case 4: result=LottoResult.삼등; break;
				case 3: result=LottoResult.사등; break;
				case 2: result=LottoResult.오등; break;
				default: result=LottoResult.꽝; break;
				}
			}
		}
		return result;
	}

	private int matchCount(String lottoNumber) {
		int count = 0;
		String[] stringNumbers = lottoNumber.split(",");
		int[] intNumbers = new int[6];
		for(int i=0; i<stringNumbers.length; i++) {
			intNumbers[i] = Integer.parseInt(stringNumbers[i]);
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(intNumbers[i] == radomNumbers()[j]) {
					count++;
				}
			}
		}
		return count;
	}

	private int[] radomNumbers() {
		int[] randoms = new int[6];
		Random random  = new Random();
		for(int i=0; i<count; i++) {
			randoms[i] = random.nextInt(45)+1;
		}
		return randoms;
	}
	
}
