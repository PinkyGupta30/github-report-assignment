package github_report_task.dto;

public class PermissionsDto
{
    private boolean admin;
    private boolean push;
    private boolean pull;

    public PermissionsDto()
    {

    }

    public boolean isAdmin()
    {
        return admin;
    }

    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }

    public boolean isPush()
    {
        return push;
    }

    public void setPush(boolean push)
    {
        this.push = push;
    }

    public boolean isPull()
    {
        return pull;
    }

    public void setPull(boolean pull)
    {
        this.pull = pull;
    }
}
