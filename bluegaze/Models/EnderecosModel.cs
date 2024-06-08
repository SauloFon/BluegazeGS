using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace bluegaze.Models
{
    [Table("Enderecos")]
    public class EnderecosModel
    {
        [Column("Id")]
        [Display(Name = "ID")]
        public int Id { get; set; }
        [Column("Rua")]
        [Display(Name = "Rua")]
        public string Rua { get; set; }
        [Column("Bairro")]
        [Display(Name = "Bairro")]
        public string Bairro { get; set; }
        [Column("Cidade")]
        [Display(Name = "Cidade")]
        public string Cidade { get; set; }
        [Column("Estado")]
        [Display(Name = "Estado")]
        public string Estado { get; set; }
        [Column("Cep")]
        [Display(Name = "Cep")]
        public string Cep { get; set; }
    }

}
