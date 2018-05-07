package WindowBuilder;

public class GeneralProperties {
	String prefix;
	String bank;
	String userLogin;
	String productSymbol;
	boolean skipErrors;
	
	public GeneralProperties(String prefix, String bank, String userLogin, String productSymbol, boolean skipErrors) {
		super();
		this.prefix = prefix;
		this.bank = bank;
		this.productSymbol = productSymbol;
		this.skipErrors = skipErrors;
		if(userLogin=="PROD") {
			this.userLogin="zz_REK_WrkFlowSrv";
		}else if (userLogin=="-2") {
			this.userLogin="dd_uf3_workflowserv";
		}else if (userLogin=="-1") {
			this.userLogin="tt_REK_WrkFlowSrv";
		}
	
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getProductSymbol() {
		return productSymbol;
	}
	public void setProductSymbol(String productSymbol) {
		this.productSymbol = productSymbol;
	}
	
	public String GenerateRecord() {
	return "<WorkflowTest name='"+productSymbol+"' bankSymbol='"+bank+"' profileSymbol='DPD_ADMIN' userLogin='"+userLogin+"' culture='pl-PL' applicationNumberPrefix=\""+prefix+"\" waitIfLocked='1'>";
	}
}
