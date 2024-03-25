package proyecto.api.service;

import proyecto.api.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> getAllUsers();
    Optional<Usuario> findUsuarioById(Long id);
    Usuario insertUsuario(Usuario usuario);
    Usuario getUsuarioByName(String nombre);
}
