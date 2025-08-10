using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class Vaccine
{
    public int VaccineId { get; set; }

    public string VaccineName { get; set; } = null!;

    public string? Description { get; set; }

    public string? AgeGroup { get; set; }

    public virtual ICollection<ChildVaccinationRecord> ChildVaccinationRecords { get; set; } = new List<ChildVaccinationRecord>();
}
