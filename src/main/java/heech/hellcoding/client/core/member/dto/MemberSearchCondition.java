package heech.hellcoding.client.core.member.dto;

import heech.hellcoding.client.core.common.dto.CommonSearchCondition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.util.StringUtils.*;

@Getter
@Setter
public class MemberSearchCondition extends CommonSearchCondition {

    private GenderCode searchGender;

    public MultiValueMap<String, String> toMultiValueMap() {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        if (this.getPage() != null) map.add("page", String.valueOf(this.getPage()));
        if (this.getSize() != null) map.add("size", String.valueOf(this.getSize()));
        if (this.getSearchCondition() != null) map.add("searchCondition", String.valueOf(this.getSearchCondition()));
        if (hasText(this.getSearchKeyword())) map.add("searchKeyword", this.getSearchKeyword());
        if (this.getSearchId() != null) map.add("searchId", String.valueOf(this.getSearchId()));
        if (hasText(this.getSearchName())) map.add("searchName", this.getSearchName());
        if (this.getSearchGender() != null) map.add("searchGender", String.valueOf(this.getSearchGender()));
        return map;
    }
}
