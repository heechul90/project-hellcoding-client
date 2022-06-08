package heech.hellcoding.client.web.member;

import heech.hellcoding.client.core.common.json.JsonResult;
import heech.hellcoding.client.core.member.dto.MemberSearchCondition;
import heech.hellcoding.client.core.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/web/client/members")
public class WebMemberController {

    private final MemberService memberService;

    /**
     * 회원 목록 조회
     */
    @GetMapping
    public JsonResult findMembers(MemberSearchCondition condition) {

        JsonResult jsonResult = memberService.findMembers(condition);

        return jsonResult;
    }

    /**
     * 회원 단건 조회
     */
    @GetMapping(value = "/{id}")
    public JsonResult findMember(@PathVariable("id") Long id) {

        JsonResult jsonResult = memberService.findMember(id);
        return jsonResult;
    }

    /**
     * 회원 저장
     */
}
