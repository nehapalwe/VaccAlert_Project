using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class Parent
{
    public int ParentId { get; set; }

    public string? AadharNumber { get; set; }

    public string? Address { get; set; }

    public string? FirstName { get; set; }

    public string? LastName { get; set; }

    public string? Occupation { get; set; }

    public int? UserId { get; set; }

    public virtual ICollection<Child> Children { get; set; } = new List<Child>();

    public virtual User? User { get; set; }
}
