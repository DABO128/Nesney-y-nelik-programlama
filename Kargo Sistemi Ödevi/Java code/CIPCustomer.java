package project;

public class CIPCustomer extends Customer {
	private String membershipNo;
	public static final double discountPercent = 5;
	
	public CIPCustomer(String customerType, String name, String surname, String telefonNo, String address, String membershipNo) {
		super(customerType, name, surname, telefonNo, address);
		this.membershipNo = membershipNo;
	}

	public String getMembershipNo() {
		return membershipNo;
	}

	public void setMembershipNo(String membershipNo) {
		this.membershipNo = membershipNo;
	}
}
