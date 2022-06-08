package heech.hellcoding.client.core.member.service;

import heech.hellcoding.client.core.common.json.JsonResult;
import heech.hellcoding.client.core.member.dto.MemberSearchCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class MemberService {

    public JsonResult findMembers(MemberSearchCondition condition) {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9000")
                .queryParams(condition.toMultiValueMap())
                .path("/api/members")
                .encode()
                .build()
                .toUri();
        log.info("request uri = {}", uri);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "aaaaaaaaaaa");

        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<JsonResult> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<JsonResult> responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);
        log.info("responseEntity.getStatusCode = {}", responseEntity.getStatusCode());
        log.info("responseEntity.getBody = {}", responseEntity.getBody().getData());
        return responseEntity.getBody();
    }

    public JsonResult findMember(Long id) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9000")
                .path("/api/members/{id}")
                .encode()
                .build()
                .expand(id)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "aaaaa");

        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<JsonResult> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<JsonResult> responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return responseEntity.getBody();
    }
}
