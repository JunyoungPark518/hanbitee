package domain;

import lombok.*;
@Data public class NurseBean {
	@Getter @Setter
	private String nurID, nurPass, majorJob, nurName, nurGen, nurPhone, nurEmail, nurPosition;
}
