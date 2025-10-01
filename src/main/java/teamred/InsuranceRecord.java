package teamred;

public class InsuranceRecord {
	public int age;
	public double bmi;
	public int children;
	public double charges;
	public String region;
	public String smoker;
	public String sex;

	public InsuranceRecord(int age, double bmi, int children, double charges, String region, String smoker, String sex) {
		this.age = age;
		this.bmi = bmi;
		this.children = children;
		this.charges = charges;
		this.region = region;
		this.smoker = smoker;
		this.sex = sex;
	}
}
