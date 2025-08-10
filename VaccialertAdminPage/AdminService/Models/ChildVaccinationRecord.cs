using System;
using System.Collections.Generic;

namespace AdminService.Models;

public partial class ChildVaccinationRecord
{
    public int ChildVaccineId { get; set; }

    public int? ChildId { get; set; }

    public int? HospitalId { get; set; }

    public int? VaccineId { get; set; }

    public DateTime? Dategiven { get; set; }

    public DateTime? Nextduedate { get; set; }

    public virtual Child? Child { get; set; }

    public virtual Hospital? Hospital { get; set; }

    public virtual Vaccine? Vaccine { get; set; }
}
