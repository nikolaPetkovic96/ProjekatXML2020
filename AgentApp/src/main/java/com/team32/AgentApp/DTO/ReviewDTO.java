package com.team32.AgentApp.DTO;

public class ReviewDTO {

        private Long id; 			//id komentara
//        private Long automobKomentarId;
//        private Long automobOcenaId;
        private String username;   //iz komentara
        private String text;
        private boolean odobren;
        private float star;
		
		public ReviewDTO() {
			super();
		}

		public ReviewDTO(OcenaDTO oc, KomentarDTO kom) {
			super();
			this.id = kom.getId();
			this.username = kom.getUsername();
			this.text = kom.getTekstKomentara();
			this.odobren = kom.isOdobren();
			this.star = oc.getVrednostOcene();
		}
		
		//Kada je sam agent ostavio komentar
		public ReviewDTO(KomentarDTO kom) {
			super();
			this.id = kom.getId();
			this.username = kom.getUsername();
			this.text = kom.getTekstKomentara();
			this.odobren = kom.isOdobren();
//			this.star = 0;
		}


		public ReviewDTO(Long id, String username, String text, boolean odobren, float star) {
			super();
			this.id = id;
			this.username = username;
			this.text = text;
			this.odobren = odobren;
			this.star = star;
		}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
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
