package ec.edu.espe.crud.usuariosWsSpringBoot.service;

import ec.edu.espe.crud.usuariosWsSpringBoot.exception.DataNotFoundException;
import ec.edu.espe.crud.usuariosWsSpringBoot.exception.UpdateException;
import ec.edu.espe.crud.usuariosWsSpringBoot.model.UsuarioEntity;
import ec.edu.espe.crud.usuariosWsSpringBoot.repository.UsuarioRepository;

import ec.edu.espe.crud.usuariosWsSpringBoot.vo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioVo> getAllUsuarios() throws DataNotFoundException {
        List<UsuarioEntity> usuarioList = this.usuarioRepository.findAll();
        List<UsuarioVo> usuarioVoList = new ArrayList<>();
        if(!usuarioList.isEmpty()){
            for (UsuarioEntity usr: usuarioList) {
                usuarioVoList.add(
                        UsuarioVo.builder()
                            .id(Integer.toString(usr.getId()))
                            .name(usr.getName())
                            .lastName(usr.getLastName())
                            .email(usr.getEmail())
                            .password(usr.getPassword())
                            .address(usr.getAddress())
                            .build()
                );
            }
            return usuarioVoList;
        }else{
            throw new DataNotFoundException("Usuario","No existen datos");
        }
    }

    public UsuarioVo getUsuarioById(Integer id) throws DataNotFoundException{
        UsuarioEntity usuario = this.usuarioRepository.getUsuarioById(id);
        if(usuario != null){
            return UsuarioVo.builder()
                            .id(Integer.toString(usuario.getId()))
                            .name(usuario.getName())
                            .lastName(usuario.getLastName())
                            .email(usuario.getEmail())
                            .password(usuario.getPassword())
                            .address(usuario.getAddress())
                            .build();
        }else{
            throw new DataNotFoundException("Usuario","No existen usuarios con id "+id);
        }
    }

    public void addUsuario(UsuarioVo usr) {
        UsuarioEntity usuarioData = new UsuarioEntity();
        usuarioData.setId(null);
        usuarioData.setName(usr.getName());
        usuarioData.setLastName(usr.getLastName());
        usuarioData.setEmail(usr.getEmail());
        usuarioData.setPassword(usr.getPassword());
        usuarioData.setAddress(usr.getAddress());
        this.usuarioRepository.save(usuarioData);
    }

    public void updateUsuario(UsuarioVo usr,Integer id) throws DataNotFoundException, UpdateException {
        Optional<UsuarioEntity> usrData = this.usuarioRepository.findAllById(id);
        if(usrData.isPresent()){
            try {
                usrData.get().setName(usr.getName());
                usrData.get().setLastName(usr.getLastName());
                usrData.get().setEmail(usr.getEmail());
                usrData.get().setPassword(usr.getPassword());
                usrData.get().setAddress(usr.getAddress());
                this.usuarioRepository.save(usrData.get());
            }catch (Exception e){
                throw new UpdateException("Usuario","No se pudo actualizar los datos del usuario con id "+id);
            }
        }else{
            throw new DataNotFoundException("Usuario","No existen usuarios con id "+id);
        }
    }

    public void deleteUsuario(Integer id) throws DataNotFoundException{
        Optional<UsuarioEntity> usrTemp = this.usuarioRepository.findAllById(id);
        if(usrTemp.isPresent()){
            this.usuarioRepository.deleteById(id);
        }else{
            throw new DataNotFoundException("Usuario","No existen usuarios con id "+id);
        }
    }

}
