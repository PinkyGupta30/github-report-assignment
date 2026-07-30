package github_report_task.dto;

public class RepositoryAccessDto
{
    private String repository;
    private PermissionsDto permissions;

    public RepositoryAccessDto()
    {

    }

    public String getRepository()
    {
        return repository;
    }

    public void setRepository(String repository)
    {
        this.repository = repository;
    }

    public PermissionsDto getPermissions()
    {
        return permissions;
    }

    public void setPermissions(PermissionsDto permissions)
    {
        this.permissions = permissions;
    }

}
