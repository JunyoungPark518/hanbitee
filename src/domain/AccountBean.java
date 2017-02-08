package domain;

import java.io.Serializable;

// ObjetStream을 쓰기 위해 Serializable
public class AccountBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id, accountType, createDate, money, accountNo;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return String.format("%s\n [%s]\n %s\n %s\n ￦:%s", 
				accountNo, accountType, id, createDate, money);
	}
}
