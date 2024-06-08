using bluegaze.Data;
using bluegaze.Models;

namespace bluegaze.Repositorio
{
    public interface IEnderecoRepository
    {
        EnderecosModel Adicionar(EnderecosModel enderecos);
    }
}
