package proyecto.api.controller;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.api.dto.UsuarioDTO;
import proyecto.api.mappers.IMapper;
import proyecto.api.model.Perfil;
import proyecto.api.model.Usuario;
import proyecto.api.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired private UsuarioService usuarioService;
    @Autowired private IMapper<Usuario, UsuarioDTO> usuarioMapper;

    //Recuperar un usuario por su id
    @GetMapping(path = "/api/usuario/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findUsuarioById(id);
        if(usuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioMapper.mapTo(usuario.get()), HttpStatus.OK);
    }

    //Recuperar todos los usuarios
    @GetMapping(path = "/api/usuarios")
    public ResponseEntity<Iterable<UsuarioDTO>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = usuarioMapper.mapTo(usuario);
            usuarioDTOS.add(usuarioDTO);
        }
        return new ResponseEntity<>(usuarioDTOS, HttpStatus.OK);
    }

    //Insertar un usuario
    @PostMapping("/api/usuario")
    public ResponseEntity<UsuarioDTO> insertarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        if (usuarioDTO.getPerfiles() == null || usuarioDTO.getPerfiles().isEmpty()) {
            // Si el usuario no tiene perfiles, devuelve un error de solicitud incorrecta (400 Bad Request)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioMapper.mapFrom(usuarioDTO);
        Usuario usuarioInsertado = usuarioService.insertUsuario(usuario);
        return new ResponseEntity<>(usuarioMapper.mapTo(usuarioInsertado), HttpStatus.CREATED);
    }

    //Modificar usuario


    //Borrar usuario
}
