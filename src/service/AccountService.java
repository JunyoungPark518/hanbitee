package service;

import domain.AccountBean;
import java.util.*;

public interface AccountService {
	// create
	public void create(AccountBean member);
	// read one
	public AccountBean findByAccountNo(String id);
	// read some
	public List<AccountBean> findByName(String name);
	// read all
	public List<AccountBean> list();
	// read special 
	public boolean checkMoney(int money);
	// update
	public void deposit(AccountBean member, int money);
	public void withdraw(AccountBean member, int money);
	// delete
	public void drop(String id);
}
