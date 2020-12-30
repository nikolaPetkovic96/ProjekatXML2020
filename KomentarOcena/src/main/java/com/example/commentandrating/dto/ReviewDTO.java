package com.example.commentandrating.dto;

public class ReviewDTO {

        private Long automobKomentarId;
        private Long automobOcenaId;
        private String username;   			//autor komentara
        private String text;
        private boolean odobren;
        private float star;
		
		public ReviewDTO() {
			super();
		}

		//Kada je user ostavio komentar I ocenu
		public ReviewDTO(OcenaDTO oc, KomentarDTO kom) {
			super();
			this.automobOcenaId = oc.getAutomobilId();
			this.star = oc.getVrednostOcene();
			this.automobKomentarId = kom.getId();
			this.username = kom.getAutor();
			this.text = kom.getTekstKomentara();
			this.odobren = kom.isOdobren();
		}
		
		//Kada je agent ostavio SAMO komentar
		public ReviewDTO(KomentarDTO kom) {
			super();
			this.automobKomentarId = kom.getId();
			this.username = kom.getAutor();
			this.text = kom.getTekstKomentara();
			this.odobren = kom.isOdobren();
		}


		public ReviewDTO(Long automobKomentarId,Long automobOcenaId, String username, String text, boolean odobren, float star) {
			super();
			this.automobKomentarId = automobKomentarId;
			this.automobOcenaId = automobOcenaId;
			this.username = username;
			this.text = text;
			this.odobren = odobren;
			this.star = star;
		}


		public Long getAutomobKomentarId() {
			return automobKomentarId;
		}

		
		public void setAutomobKomentarId(Long automobKomentarId) {
			this.automobKomentarId = automobKomentarId;
		}

		
		public Long getAutomobOcenaId() {
			return automobOcenaId;
		}

		
		public void setAutomobOcenaId(Long automobOcenaId) {
			this.automobOcenaId = automobOcenaId;
		}

		
		public String getUsername() {
			return username;
		}
		

		public void setUsername(String username) {
			this.username = username;
		}


		public String getText() {
			return text;
		}


		public void setText(String text) {
			this.text = text;
		}


		public boolean isOdobren() {
			return odobren;
		}


		public void setOdobren(boolean odobren) {
			this.odobren = odobren;
		}


		public float getStar() {
			return star;
		}


		public void setStar(float star) {
			this.star = star;
		}
     
}
