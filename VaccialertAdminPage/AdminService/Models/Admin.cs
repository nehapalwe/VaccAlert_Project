using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class Admin
{
    public int AdminId { get; set; }

    public int? UserId { get; set; }

    public virtual User? User { get; set; }
}
