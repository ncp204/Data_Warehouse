package test;

public class Lottery {
	private String date;
	private String province;
	private String prizeDB;
	private String prize1;
	private String prize2;
	private String prize3;
	private String prize4;
	private String prize5;
	private String prize6;
	private String prize7;
	private String prize8;

	public Lottery() {
	}

	public Lottery(String date, String province, String prizeDB, String prize1, String prize2, String prize3,
			String prize4, String prize5, String prize6, String prize7, String prize8) {
		super();
		this.date = date;
		this.province = province;
		this.prizeDB = prizeDB;
		this.prize1 = prize1;
		this.prize2 = prize2;
		this.prize3 = prize3;
		this.prize4 = prize4;
		this.prize5 = prize5;
		this.prize6 = prize6;
		this.prize7 = prize7;
		this.prize8 = prize8;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPrizeDB() {
		return prizeDB;
	}

	public void setPrizeDB(String prizeDB) {
		this.prizeDB = prizeDB;
	}

	public String getPrize1() {
		return prize1;
	}

	public void setPrize1(String prize1) {
		this.prize1 = prize1;
	}

	public String getPrize2() {
		return prize2;
	}

	public void setPrize2(String prize2) {
		this.prize2 = prize2;
	}

	public String getPrize3() {
		return prize3;
	}

	public void setPrize3(String prize3) {
		this.prize3 = prize3;
	}

	public String getPrize4() {
		return prize4;
	}

	public void setPrize4(String prize4) {
		this.prize4 = prize4;
	}

	public String getPrize5() {
		return prize5;
	}

	public void setPrize5(String prize5) {
		this.prize5 = prize5;
	}

	public String getPrize6() {
		return prize6;
	}

	public void setPrize6(String prize6) {
		this.prize6 = prize6;
	}

	public String getPrize7() {
		return prize7;
	}

	public void setPrize7(String prize7) {
		this.prize7 = prize7;
	}

	public String getPrize8() {
		return prize8;
	}

	public void setPrize8(String prize8) {
		this.prize8 = prize8;
	}

	public String getInfor() {
		return date + "\t" + province + "\t" + prizeDB + "\t" + prize1 + "\t" + prize2 + "\t" + prize3 + "\t" + prize4
				+ "\t" + prize5 + "\t" + prize6 + "\t" + prize7 + "\t" + prize8;
	}

	public void replaceSpaceToMinus() {
		if (prizeDB != null)
			prizeDB = prizeDB.trim().replace(' ', '-');
		if (prize1 != null)
			prize1 = prize1.trim().replace(' ', '-');
		if (prize2 != null)
			prize2 = prize2.trim().replace(' ', '-');
		if (prize3 != null)
			prize3 = prize3.trim().replace(' ', '-');
		if (prize4 != null)
			prize4 = prize4.trim().replace(' ', '-');
		if (prize5 != null)
			prize5 = prize5.trim().replace(' ', '-');
		if (prize6 != null)
			prize6 = prize6.trim().replace(' ', '-');
		if (prize7 != null)
			prize7 = prize7.trim().replace(' ', '-');
		if (prize8 != null)
			prize8 = prize8.trim().replace(' ', '-');
	}
}
