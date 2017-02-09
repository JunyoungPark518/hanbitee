package serviceImpl;

import java.util.*;
import constants.Account;
import domain.AccountBean;
import domain.MemberBean;
import service.AccountService;
import util.RandomGen;

/**
@FILE  : BankServiceImpl.java
@DATE  : 2017. 1. 24.
@AUTHOR: J.John Park
@STORY	Logic(Business Logic)

 */
public class AccountServiceImpl implements AccountService {
	// 사용하고 나서도 계속 유지되는 패턴 <- 연관관계(Association Relationships)
	Map<String, AccountBean> list;  
	
	// has a
	public AccountServiceImpl() {
		list = new HashMap<String, AccountBean>();
	}
	
	public AccountBean createAccount(String uid, String accountType) {
		AccountBean account = new AccountBean(); // 사용하고 나서 없어지는 패턴 <- 의존관계(Dependency Relationships)
		account.setAccountNo(String.valueOf(RandomGen.getRandomNum(999999, 100000)));
		account.setCreateDate(Calendar.getInstance().get(Calendar.YEAR) + "년 "
				+ Calendar.getInstance().get(Calendar.MONTH) + 1 + "월 "
				+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "일");
		account.setId(uid);
		account.setAccountType(accountType);
		account.setMoney("0");
		list.put(account.getId(), account);
		return account;
	}
	
	@Override
	public boolean checkMoney(int money) {
		return money>=0;
	}


	@Override
	public void create(AccountBean member) {
		list.put(member.getId(), member);
	}

	@Override
	public AccountBean findByAccountNo(String accountNo) {
		AccountBean temp = new AccountBean();
		for(AccountBean a : list()) {
			if(accountNo.equals(a.getAccountNo())) {
				temp = a;
				break;
			}
		}
		return temp;
	}

	@Override
	public void drop(String accountNo) {
		list.remove(accountNo);
	}

	@Override
	public List<AccountBean> findByName(String accountType) {
		List<AccountBean> temp = new ArrayList<AccountBean>();
		for(Map.Entry<String, AccountBean> a : list.entrySet()) {
			if(accountType.equals(a.getValue().getAccountType())) {
				temp.add(a.getValue());
			}
		}
		return temp;
	}

	@Override
	public List<AccountBean> list() {
		List<AccountBean> temp = new ArrayList<AccountBean>();
		for(Map.Entry<String, AccountBean> a : list.entrySet()) {
			temp.add(a.getValue());
		}
		return temp;
	}

	@Override
	public void deposit(AccountBean member, int money) {
		if(checkMoney(money)) {
			member.setMoney(String.valueOf(Integer.parseInt(member.getMoney()) + money));
			list.put(member.getId(), member);
		}
	}

	@Override
	public void withdraw(AccountBean member, int money) {
		if(checkMoney(Integer.parseInt(member.getMoney()) - money)) {
			member.setMoney(String.valueOf(Integer.parseInt(member.getMoney()) - money));
			list.put(member.getId(), member);
		}
	}
}
