using bluegaze.Data;
using bluegaze.Models;

namespace bluegaze.Repositorio
{
    public class EnderecoRepository : IEnderecoRepository
    {
        private readonly DbaseContext _dbaseContext;
        public EnderecoRepository(DbaseContext dbaseContext)
        {
            _dbaseContext = dbaseContext;
        }
        public EnderecosModel Adicionar(EnderecosModel endereco)
        {
            _dbaseContext.EnderecosModel.Add(endereco);
            _dbaseContext.SaveChanges();
            return endereco;
        }
    }
}
