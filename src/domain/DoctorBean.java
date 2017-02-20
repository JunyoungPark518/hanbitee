package domain;

import lombok.*;
@Data public class DoctorBean{
	@Getter @Setter
	private String docID, docPass, majorTreat, docName, docGen, docPhone, docEmail, docPosition;
}
