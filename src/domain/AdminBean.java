package domain;

import lombok.*;

@Data
public class AdminBean{
	@Getter @Setter
	private String adminID, admPass, admName, admGen, admPhone, admEmail, admPermission;
}
