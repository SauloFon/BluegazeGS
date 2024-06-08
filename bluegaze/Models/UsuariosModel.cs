using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace bluegaze.Models
{
    [Table("Usuarios")]
    public class UsuariosModel
    {
        [Column("Id")]
        [Display(Name = "ID")]
        public int Id { get; set; }
        [Column("Username")]
        [Display(Name = "Username")]
        public string Username { get; set; }
        [Column("Email")]
        [Display(Name = "Email")]
        public string Email { get; set; }
        [Column("CriadoEm")]
        [Display(Name = "CriadoEm")]
        public string CriadoEm { get; set; }
    }
}
