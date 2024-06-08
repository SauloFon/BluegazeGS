using bluegaze.Data;
using bluegaze.Models;

namespace bluegaze.Repositorio
{
    public class UsuarioRepository : IUsuarioRepository
    {
        private readonly DbaseContext _dbaseContext;
        public UsuarioRepository(DbaseContext dbaseContext)
        {
            _dbaseContext = dbaseContext;
        }
        public UsuariosModel Adicionar(UsuariosModel usuario)
        {
            _dbaseContext.UsuariosModel.Add(usuario);
            _dbaseContext.SaveChanges();
            return usuario;
        }
    }
}
