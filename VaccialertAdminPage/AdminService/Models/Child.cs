using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class Child
{
    public int ChildId { get; set; }

    public int? ParentId { get; set; }

    public string? ChildName { get; set; }

    public DateOnly? Dob { get; set; }

    public string? Gender { get; set; }

    public string? BloodGroup { get; set; }

    public double? Weight { get; set; }

    public double? Height { get; set; }

    public string? MedicalHistory { get; set; }

    public virtual ICollection<ChildVaccinationRecord> ChildVaccinationRecords { get; set; } = new List<ChildVaccinationRecord>();

    public virtual Parent? Parent { get; set; }
}
