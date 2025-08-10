using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class User
{
    public int UserId { get; set; }

    public string? Name { get; set; }

    public string Password { get; set; } = null!;

    public string? Email { get; set; }

    public string? ContactNo { get; set; }

    public int? RoleId { get; set; }

    public ulong? Status { get; set; }

    public virtual ICollection<Admin> Admins { get; set; } = new List<Admin>();

    public virtual ICollection<Hospital> Hospitals { get; set; } = new List<Hospital>();

    public virtual ICollection<Parent> Parents { get; set; } = new List<Parent>();

    public virtual Role? Role { get; set; }
}
