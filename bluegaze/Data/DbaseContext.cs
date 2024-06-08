using bluegaze.Models;
using Microsoft.EntityFrameworkCore;

namespace bluegaze.Data
{
    public class DbaseContext : DbContext
    {
        public DbaseContext(DbContextOptions<DbaseContext> options) : base(options)
        {

        }
        public DbSet<bluegaze.Models.EnderecosModel> EnderecosModel { get; set; } = default!;
        public DbSet<bluegaze.Models.UsuariosModel> UsuariosModel { get; set; } = default!;


    }
}

