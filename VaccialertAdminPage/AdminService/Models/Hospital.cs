using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class Hospital
{
    public int HospitalId { get; set; }

    public string? HospitalName { get; set; }

    public string? RegistrationNumber { get; set; }

    public int? UserId { get; set; }

    public string? Address { get; set; }

    public string? Telno { get; set; }

    public virtual ICollection<ChildVaccinationRecord> ChildVaccinationRecords { get; set; } = new List<ChildVaccinationRecord>();

    public virtual User? User { get; set; }
}
