package github_report_task.dto;

public class CollaboratorDto
{
    private String login;
    private PermissionsDto permissions;

    public CollaboratorDto()
    {

    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
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
