package github_report_task.service;

import github_report_task.client.GithubClient;
import github_report_task.dto.CollaboratorDto;
import github_report_task.dto.RepositoryAccessDto;
import github_report_task.dto.RepositoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GithubService
{
    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient)
    {
        this.githubClient = githubClient;
    }
    public List<RepositoryDto> getRepositories(String org)
    {
        return githubClient.getRepositories(org);
    }

    public List<CollaboratorDto> getCollaborators(String owner, String repo)
    {
        return githubClient.getCollaborators(owner, repo);
    }

    public Map<String, List<RepositoryAccessDto>> getAccessReport(String org)
    {
        List<RepositoryDto> repositories = githubClient.getRepositories(org);

        Map<String, List<RepositoryAccessDto>> report = new HashMap<>();

        for (RepositoryDto repository : repositories)
        {
            List<CollaboratorDto> collaborators =
                    githubClient.getCollaborators(org, repository.getName());

            for (CollaboratorDto collaborator : collaborators)
            {
                RepositoryAccessDto access = new RepositoryAccessDto();

                access.setRepository(repository.getName());
                access.setPermissions(collaborator.getPermissions());

                report.computeIfAbsent(collaborator.getLogin(),
                        k -> new ArrayList<>()).add(access);
            }
        }

        return report;
    }
}
