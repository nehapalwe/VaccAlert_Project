using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;

namespace AdminService.Models;

public partial class P23ChildVaccineDbContext : DbContext
{
    public P23ChildVaccineDbContext()
    {
    }

    public P23ChildVaccineDbContext(DbContextOptions<P23ChildVaccineDbContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Admin> Admins { get; set; }

    public virtual DbSet<Child> Children { get; set; }

    public virtual DbSet<ChildVaccinationRecord> ChildVaccinationRecords { get; set; }

    public virtual DbSet<Hospital> Hospitals { get; set; }

    public virtual DbSet<Parent> Parents { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<User> Users { get; set; }

    public virtual DbSet<Vaccine> Vaccines { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;database=p23_child_vaccine_db;user=root;password=Zxcvbnm_@1", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.37-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Admin>(entity =>
        {
            entity.HasKey(e => e.AdminId).HasName("PRIMARY");

            entity.ToTable("admin");

            entity.HasIndex(e => e.UserId, "user_id");

            entity.Property(e => e.AdminId).HasColumnName("admin_id");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.Admins)
                .HasForeignKey(d => d.UserId)
                .HasConstraintName("admin_ibfk_1");
        });

        modelBuilder.Entity<Child>(entity =>
        {
            entity.HasKey(e => e.ChildId).HasName("PRIMARY");

            entity.ToTable("child");

            entity.HasIndex(e => e.ParentId, "parent_id");

            entity.Property(e => e.ChildId).HasColumnName("child_id");
            entity.Property(e => e.BloodGroup)
                .HasMaxLength(255)
                .HasColumnName("blood_group");
            entity.Property(e => e.ChildName)
                .HasMaxLength(255)
                .HasColumnName("child_name");
            entity.Property(e => e.Dob).HasColumnName("dob");
            entity.Property(e => e.Gender)
                .HasMaxLength(255)
                .HasColumnName("gender");
            entity.Property(e => e.Height).HasColumnName("height");
            entity.Property(e => e.MedicalHistory)
                .HasMaxLength(255)
                .HasColumnName("medical_history");
            entity.Property(e => e.ParentId).HasColumnName("parent_id");
            entity.Property(e => e.Weight).HasColumnName("weight");

            entity.HasOne(d => d.Parent).WithMany(p => p.Children)
                .HasForeignKey(d => d.ParentId)
                .HasConstraintName("child_ibfk_1");
        });

        modelBuilder.Entity<ChildVaccinationRecord>(entity =>
        {
            entity.HasKey(e => e.ChildVaccineId).HasName("PRIMARY");

            entity.ToTable("child_vaccination_record");

            entity.HasIndex(e => e.ChildId, "child_id");

            entity.HasIndex(e => e.HospitalId, "hospital_id");

            entity.HasIndex(e => e.VaccineId, "vaccine_id");

            entity.Property(e => e.ChildVaccineId).HasColumnName("child_vaccine_id");
            entity.Property(e => e.ChildId).HasColumnName("child_id");
            entity.Property(e => e.Dategiven)
                .HasMaxLength(6)
                .HasColumnName("dategiven");
            entity.Property(e => e.HospitalId).HasColumnName("hospital_id");
            entity.Property(e => e.Nextduedate)
                .HasMaxLength(6)
                .HasColumnName("nextduedate");
            entity.Property(e => e.VaccineId).HasColumnName("vaccine_id");

            entity.HasOne(d => d.Child).WithMany(p => p.ChildVaccinationRecords)
                .HasForeignKey(d => d.ChildId)
                .HasConstraintName("child_vaccination_record_ibfk_1");

            entity.HasOne(d => d.Hospital).WithMany(p => p.ChildVaccinationRecords)
                .HasForeignKey(d => d.HospitalId)
                .HasConstraintName("child_vaccination_record_ibfk_2");

            entity.HasOne(d => d.Vaccine).WithMany(p => p.ChildVaccinationRecords)
                .HasForeignKey(d => d.VaccineId)
                .HasConstraintName("child_vaccination_record_ibfk_3");
        });

        modelBuilder.Entity<Hospital>(entity =>
        {
            entity.HasKey(e => e.HospitalId).HasName("PRIMARY");

            entity.ToTable("hospital");

            entity.HasIndex(e => e.RegistrationNumber, "registration_number").IsUnique();

            entity.HasIndex(e => e.UserId, "user_id");

            entity.Property(e => e.HospitalId).HasColumnName("hospital_id");
            entity.Property(e => e.Address)
                .HasMaxLength(255)
                .HasColumnName("address");
            entity.Property(e => e.HospitalName)
                .HasMaxLength(255)
                .HasColumnName("hospital_name");
            entity.Property(e => e.RegistrationNumber).HasColumnName("registration_number");
            entity.Property(e => e.Telno)
                .HasMaxLength(255)
                .HasColumnName("telno");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.Hospitals)
                .HasForeignKey(d => d.UserId)
                .HasConstraintName("hospital_ibfk_1");
        });

        modelBuilder.Entity<Parent>(entity =>
        {
            entity.HasKey(e => e.ParentId).HasName("PRIMARY");

            entity.ToTable("parents");

            entity.HasIndex(e => e.AadharNumber, "aadhar_number").IsUnique();

            entity.HasIndex(e => e.UserId, "user_id");

            entity.Property(e => e.ParentId).HasColumnName("parent_id");
            entity.Property(e => e.AadharNumber).HasColumnName("aadhar_number");
            entity.Property(e => e.Address)
                .HasMaxLength(255)
                .HasColumnName("address");
            entity.Property(e => e.FirstName)
                .HasMaxLength(255)
                .HasColumnName("first_name");
            entity.Property(e => e.LastName)
                .HasMaxLength(255)
                .HasColumnName("last_name");
            entity.Property(e => e.Occupation)
                .HasMaxLength(255)
                .HasColumnName("occupation");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.Parents)
                .HasForeignKey(d => d.UserId)
                .HasConstraintName("parents_ibfk_1");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.RoleId).HasName("PRIMARY");

            entity.ToTable("roles");

            entity.HasIndex(e => e.RoleName, "role_name").IsUnique();

            entity.Property(e => e.RoleId).HasColumnName("role_id");
            entity.Property(e => e.RoleName).HasColumnName("role_name");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.UserId).HasName("PRIMARY");

            entity.ToTable("users");

            entity.HasIndex(e => e.Email, "email").IsUnique();

            entity.HasIndex(e => e.RoleId, "role_id");

            entity.Property(e => e.UserId).HasColumnName("user_id");
            entity.Property(e => e.ContactNo)
                .HasMaxLength(255)
                .HasColumnName("contact_no");
            entity.Property(e => e.Email).HasColumnName("email");
            entity.Property(e => e.Name)
                .HasMaxLength(255)
                .HasColumnName("name");
            entity.Property(e => e.Password)
                .HasMaxLength(255)
                .HasColumnName("password");
            entity.Property(e => e.RoleId).HasColumnName("role_id");
            entity.Property(e => e.Status)
                .HasColumnType("bit(1)")
                .HasColumnName("status");

            entity.HasOne(d => d.Role).WithMany(p => p.Users)
                .HasForeignKey(d => d.RoleId)
                .HasConstraintName("users_ibfk_1");
        });

        modelBuilder.Entity<Vaccine>(entity =>
        {
            entity.HasKey(e => e.VaccineId).HasName("PRIMARY");

            entity.ToTable("vaccines");

            entity.Property(e => e.VaccineId).HasColumnName("vaccine_id");
            entity.Property(e => e.AgeGroup)
                .HasMaxLength(255)
                .HasColumnName("age_group");
            entity.Property(e => e.Description)
                .HasMaxLength(255)
                .HasColumnName("description");
            entity.Property(e => e.VaccineName)
                .HasMaxLength(255)
                .HasColumnName("vaccine_name");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
