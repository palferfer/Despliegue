package proyecto.api.mappers.imp;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proyecto.api.dto.UsuarioDTO;
import proyecto.api.model.Usuario;
import org.modelmapper.ModelMapper;
import proyecto.api.mappers.IMapper;



@Component
public class UsuarioMapper implements IMapper<Usuario, proyecto.api.dto.UsuarioDTO> {

    @Autowired ModelMapper modelMapper;

    @Override
    public UsuarioDTO mapTo(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    public Usuario mapFrom(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
