//using AdminService.Models;
//using Microsoft.AspNetCore.Mvc;
//using Microsoft.EntityFrameworkCore;

//namespace AdminService.Controllers
//{
//    [Route("api/[controller]")]
//    [ApiController]
//    public class UserController : ControllerBase
//    {

//        private readonly Models.P23ChildVaccineDbContext _context;

//        public UserController(Models.P23ChildVaccineDbContext context)
//        {
//            _context = context;
//        }

//        // GET: api/User

//        [HttpGet]
//        public async Task<ActionResult<IEnumerable<UserDto>>> GetAllUsers()
//        {
//            var users = await _context.Users
//                .Include(u => u.Role)
//                .Select(u => new UserDto
//                {
//                    UserId = u.UserId,
//                    Name = u.Name,
//                    Email = u.Email,
//                    ContactNo = u.ContactNo,
//                    Status = (int)(u.Status ?? 0),
//                    Role = u.Role != null ? u.Role.RoleName : "N/A"
//                })
//                .ToListAsync();

//            return Ok(users);
//        }



//        // GET: api/User/5
//        [HttpGet("{id}")]
//        public async Task<ActionResult<User>> GetUser(int id)
//        {
//            var user = await _context.Users
//                .Include(u => u.Role)
//                .FirstOrDefaultAsync(u => u.UserId == id);

//            if (user == null)
//                return NotFound();

//            return Ok(user);
//        }

//        // PUT: api/User/disable/5
//        [HttpPut("disable/{id}")]
//        public async Task<IActionResult> DisableUser(int id)
//        {
//            var user = await _context.Users.FindAsync(id);
//            if (user == null)
//                return NotFound();

//            user.Status = 0;
//            await _context.SaveChangesAsync();

//            return Ok(user);
//        }

//        // PUT: api/User/5/status
//        [HttpPut]
//        [Route("{userId}/status")]
//        public async Task<IActionResult> UpdateUserStatus(int userId, [FromBody] int newStatus)
//        {
//            var user = await _context.Users.FindAsync(userId);

//            if (user == null)
//            {
//                return NotFound("User not found.");
//            }

//            user.Status = (ulong)newStatus;
//            await _context.SaveChangesAsync();

//            return Ok("User status updated successfully.");
//        }




//        [HttpGet("report-range")]
//        public IActionResult GetReportSummaryByDateRange([FromQuery] DateOnly from, [FromQuery] DateOnly to)
//        {
//            var fromDateTime = from.ToDateTime(TimeOnly.MinValue);
//            var toDateTime = to.ToDateTime(TimeOnly.MaxValue);

//            var records = _context.ChildVaccinationRecords
//                .Include(r => r.Vaccine)
//                .Include(r => r.Child)
//                .Where(r => r.Dategiven >= fromDateTime && r.Dategiven <= toDateTime)
//                .ToList();

//            if (!records.Any())
//            {
//                return Ok(new
//                {
//                    mostTakenVaccine = "None",
//                    totalVaccines = 0,
//                    totalChildren = 0
//                });
//            }

//            var mostTakenVaccine = records
//                .GroupBy(r => r.Vaccine.VaccineName)
//                .OrderByDescending(g => g.Count())
//                .First().Key;

//            var totalVaccines = records.Count;
//            var totalChildren = records.Select(r => r.ChildId).Distinct().Count();

//            return Ok(new
//            {
//                mostTakenVaccine,
//                totalVaccines,
//                totalChildren
//            });
//        }



//        [HttpGet("by-role/{roleName}")]
//        public IActionResult GetUsersByRole(string roleName)
//        {
//            var users = _context.Users
//                .Where(u => u.Role != null && u.Role.RoleName.ToLower() == roleName.ToLower())
//                .Select(u => new
//                {
//                    u.UserId,
//                    u.Name,
//                    u.Email,
//                    u.ContactNo,
//                    Role = u.Role.RoleName,
//                    u.Status
//                })
//                .ToList();

//            return Ok(users);
//        }
//    }
//}




using AdminService.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace AdminService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly Models.P23ChildVaccineDbContext _context;

        public UserController(Models.P23ChildVaccineDbContext context)
        {
            _context = context;
        }

        // GET: api/User
        [HttpGet]
        public async Task<ActionResult<IEnumerable<UserDto>>> GetAllUsers()
        {
            var users = await _context.Users
                .Include(u => u.Role)
                .Select(u => new UserDto
                {
                    UserId = u.UserId,
                    Name = u.Name,
                    Email = u.Email,
                    ContactNo = u.ContactNo,
                    Status = (int)(u.Status ?? 0),
                    Role = u.Role != null ? u.Role.RoleName : "N/A"
                })
                .ToListAsync();

            return Ok(users);
        }

        // GET: api/User/5
        [HttpGet("{id}")]
        public async Task<ActionResult<User>> GetUser(int id)
        {
            var user = await _context.Users
                .Include(u => u.Role)
                .FirstOrDefaultAsync(u => u.UserId == id);

            if (user == null)
                return NotFound();

            return Ok(user);
        }

        // PUT: api/User/disable/5
        [HttpPut("disable/{id}")]
        public async Task<IActionResult> DisableUser(int id)
        {
            var user = await _context.Users.FindAsync(id);
            if (user == null)
                return NotFound();

            user.Status = 0;
            await _context.SaveChangesAsync();

            return Ok(user);
        }

        // PUT: api/User/{userId}/status
        [HttpPut("{userId}/status")]
        public async Task<IActionResult> UpdateUserStatus(int userId, [FromBody] int newStatus)
        {
            var user = await _context.Users.FindAsync(userId);

            if (user == null)
            {
                return NotFound("User not found.");
            }

            user.Status = (ulong)newStatus;
            await _context.SaveChangesAsync();

            return Ok("User status updated successfully.");
        }

        // GET: api/User/report-range
        [HttpGet("report-range")]
        public IActionResult GetReportSummaryByDateRange([FromQuery] DateOnly from, [FromQuery] DateOnly to)
        {
            var fromDateTime = from.ToDateTime(TimeOnly.MinValue);
            var toDateTime = to.ToDateTime(TimeOnly.MaxValue);

            var records = _context.ChildVaccinationRecords
                .Include(r => r.Vaccine)
                .Include(r => r.Child)
                .Where(r => r.Dategiven.HasValue &&
                            r.Dategiven.Value >= fromDateTime &&
                            r.Dategiven.Value <= toDateTime)
                .ToList();

            if (!records.Any())
            {
                return Ok(new
                {
                    mostTakenVaccine = "None",
                    totalVaccines = 0,
                    totalChildren = 0
                });
            }

            var mostTakenVaccine = records
                .Where(r => r.Vaccine != null)
                .GroupBy(r => r.Vaccine!.VaccineName)
                .OrderByDescending(g => g.Count())
                .FirstOrDefault()?.Key ?? "None";

            var totalVaccines = records.Count;
            var totalChildren = records
                .Where(r => r.ChildId.HasValue)
                .Select(r => r.ChildId!.Value)
                .Distinct()
                .Count();

            return Ok(new
            {
                mostTakenVaccine,
                totalVaccines,
                totalChildren
            });
        }

        // GET: api/User/by-role/{roleName}
        [HttpGet("by-role/{roleName}")]
        public IActionResult GetUsersByRole(string roleName)
        {
            var users = _context.Users
                .Where(u => u.Role != null && u.Role.RoleName.ToLower() == roleName.ToLower())
                .Select(u => new
                {
                    u.UserId,
                    u.Name,
                    u.Email,
                    u.ContactNo,
                    Role = u.Role.RoleName,
                    u.Status
                })
                .ToList();

            return Ok(users);
        }
    }
}
