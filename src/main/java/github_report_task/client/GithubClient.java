package github_report_task.client;

import github_report_task.dto.CollaboratorDto;
import github_report_task.dto.RepositoryDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GithubClient
{
    private final RestTemplate restTemplate;

    @Value("${github.base-url}")
    private String baseUrl;

    @Value("${github.token}")
    private String token;

    public GithubClient(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public List<RepositoryDto> getRepositories(String org)
    {
        String url = baseUrl + "/orgs/" + org + "/repos";
        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<RepositoryDto[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                RepositoryDto[].class
        );


        return Arrays.asList(response.getBody());
    }
    public List<CollaboratorDto> getCollaborators(String owner, String repo)
    {
        String url = baseUrl + "/repos/" + owner + "/" + repo + "/collaborators";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CollaboratorDto[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                CollaboratorDto[].class
        );

        return Arrays.asList(response.getBody());
    }
}
