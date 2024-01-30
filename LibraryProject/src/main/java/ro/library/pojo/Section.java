package ro.library.pojo;

public class Section {

		private int idSection;
		private String name;
		private int amount;
		
		public Section(int idSection, String name, int amount) {
			this.idSection = idSection;
			this.name = name;
			this.amount = amount;
		}

		public Section() {

		}

		
		public int getIdSection() {
			return idSection;
		}

		public void setIdSection(int idSection) {
			this.idSection = idSection;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		
}
