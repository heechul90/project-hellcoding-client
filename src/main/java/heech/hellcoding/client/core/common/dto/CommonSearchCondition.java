package heech.hellcoding.client.core.common.dto;

import heech.hellcoding.client.core.common.pagenation.Pagination;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonSearchCondition extends Pagination {

    /** 검색 조건 */
    private SearchCondition searchCondition;
    private String searchKeyword;

    private Long searchId;
    private String searchName;

}
