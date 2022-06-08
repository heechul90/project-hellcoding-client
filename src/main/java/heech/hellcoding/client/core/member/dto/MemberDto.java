package heech.hellcoding.client.core.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {

    private String memberName;
    private String email;
    private String birthDate;
    private String gender;
    private String phoneNumber;
    private String address;
}
