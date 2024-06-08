using bluegaze.Models;

namespace bluegaze.Repositorio
{
    public interface IUsuarioRepository
    {
        UsuariosModel Adicionar(UsuariosModel usuario);
    }
}
