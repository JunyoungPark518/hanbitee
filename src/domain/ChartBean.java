package domain;

import java.io.Serializable;

import lombok.*;

@Data
public class ChartBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private String chartID, treatID, docID, nurID, patID, chartContent;
}
