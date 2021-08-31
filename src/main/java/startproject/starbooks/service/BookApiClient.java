package startproject.starbooks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import startproject.starbooks.domain.dto.BooksResponseDto;

@Service
@RequiredArgsConstructor
public class BookApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String CLIENT_ID = "iwiv4hyEsn9OadIJalVT";
    private final String CLIENT_SECRET = "waPsYApUJF";

    private  final String OpenNaverBookUrl_getBooks = "https://openapi.naver.com/v1/search/book_adv?d_titl={keyword}";


    public BooksResponseDto requestBook(String keyword){
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(OpenNaverBookUrl_getBooks, HttpMethod.GET, entity, BooksResponseDto.class, keyword).getBody();
    }


}