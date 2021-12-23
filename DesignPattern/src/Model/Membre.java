package Model;

import java.io.InputStream;

public class Membre {
		//All final attributes
		private final String ID;//required
		private final String NomComplet; // required
		private final String Specialite; // required
		private final int age; // optional
		private final String phone; // optional
		private final String addresse; // optional
		private final String dateDebut;//required
		private final String dateFin;//required
		private final InputStream fileImage;

		private Membre(MemberBuilder builder) {
			this.ID = builder.ID;
			this.NomComplet = builder.NomComplet;
			this.Specialite = builder.Specialite;
			this.age = builder.age;
			this.phone = builder.phone;
			this.addresse = builder.addresse;
			this.dateDebut = builder.dateDebut;
			this.dateFin = builder.dateFin;
			this.fileImage=builder.fileImage;
		}

		public String getID() {
			return ID;
		}

		public String getNomComplet() {
			return NomComplet;
		}

		public String getSpecialite() {
			return Specialite;
		}

		public String getAddresse() {
			return addresse;
		}

		public String getDateDebut() {
			return dateDebut;
		}

		public String getDateFin() {
			return dateFin;
		}

		
		public InputStream getFileImage() {
			return fileImage;
		}

		public int getAge() {
			return age;
		}

		public String getPhone() {
			return phone;
		}

		@Override
		public String toString() {
			return "Membre: "+this.ID+", "+this.NomComplet+", "+this.Specialite+", "+this.age+", "+this.phone+","+this.addresse+","+this.dateDebut+","+this.dateFin;
		}

		public static class MemberBuilder
		{
			private final String ID;
			private final String NomComplet;
			private final String Specialite;
			private int age; 
			private String phone; 
			private String addresse; 
			private final String dateDebut;
			private final String dateFin;
			private InputStream fileImage;

	
			public MemberBuilder(String iD, String nomComplet, String specialite, String dateDebut, String dateFin) {
				this.ID = iD;
				this.NomComplet = nomComplet;
				this.Specialite = specialite;
				this.dateDebut = dateDebut;
				this.dateFin = dateFin;
			}
			
			public MemberBuilder age(int age) {
				this.age = age;
				return this;
			}
			public MemberBuilder phone(String phone) {
				this.phone = phone;
				return this;
			}
			public MemberBuilder address(String address) {
				this.addresse = address;
				return this;
			}
			public MemberBuilder fileImage(InputStream fileImage) {
				this.fileImage = fileImage;
				return this;
			}
			//Return the finally consrcuted User object
			public Membre build() {
				Membre membre =  new Membre(this);
				validateUserObject(membre);
				return membre;
			}
			private void validateUserObject(Membre membre) {
				//Do some basic validations to check
				//if user object does not break any assumption of system
			}
			

		}
	}