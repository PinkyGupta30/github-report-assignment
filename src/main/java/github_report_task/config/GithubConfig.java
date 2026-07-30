package github_report_task.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubConfig
{
    @Value("${github.base-url}")
    private String baseUrl;

    @Value("${github.token}")
    private String token;

    @PostConstruct
    public void init()
    {
        System.out.println("Github Base URL: " +baseUrl);
        System.out.println("Token Loaded: " + (token != null && !token.isEmpty()));
    }

}
