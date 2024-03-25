package proyecto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.api.model.Usuario;
import proyecto.api.repository.IUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        if(usuario != null && getUsuarioByName(usuario.getNombre()) == null){
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario getUsuarioByName(String nombre) {
        if(nombre!=null){
            return usuarioRepository.findByNombre(nombre);
        }
        return null;
    }
}
