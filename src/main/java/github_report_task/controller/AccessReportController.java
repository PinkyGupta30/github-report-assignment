package github_report_task.controller;

import github_report_task.client.GithubClient;
import github_report_task.dto.CollaboratorDto;
import github_report_task.dto.RepositoryAccessDto;
import github_report_task.dto.RepositoryDto;
import github_report_task.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AccessReportController
{
    private final GithubService githubService;

    public AccessReportController(GithubService githubService)
    {
        this.githubService = githubService;
    }



    @GetMapping("/repos/{org}")
    public List<RepositoryDto> getRepositories(@PathVariable String org)
    {
        return githubService.getRepositories(org);
    }

    @GetMapping("/collaborators/{owner}/{repo}")
    public List<CollaboratorDto> getCollaborators(
            @PathVariable String owner,
            @PathVariable String repo)
    {
        return githubService.getCollaborators(owner, repo);
    }

    @GetMapping("/access-report/{org}")
    public Map<String, List<RepositoryAccessDto>> getAccessReport(
            @PathVariable String org)
    {
        return githubService.getAccessReport(org);
    }

}

