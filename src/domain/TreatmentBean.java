package domain;

import lombok.*;

@Data
public class TreatmentBean {
	@Getter @Setter
	private String treatId, patId, docId, treatContents, treatDate;
}
