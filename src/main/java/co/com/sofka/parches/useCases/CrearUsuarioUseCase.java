package co.com.sofka.parches.useCases;

import co.com.sofka.parches.collections.Usuario;
import co.com.sofka.parches.dtos.UsuarioDTO;
import co.com.sofka.parches.mappers.MapperUtils;
import co.com.sofka.parches.repositories.UsuarioRepository;
import co.com.sofka.parches.utils.Firebase;
import co.com.sofka.parches.utils.Validaciones;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@Service
@Validated
public class CrearUsuarioUseCase implements CrearUsuario {
    private final UsuarioRepository usuarioRepository;
    private final MapperUtils mapperUtils;
    private final Validaciones validaciones;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository, MapperUtils mapperUtils, Validaciones validaciones) {
        this.usuarioRepository = usuarioRepository;
        this.mapperUtils = mapperUtils;
        this.validaciones = validaciones;
    }

    @Override
    public Mono<UsuarioDTO> apply(UsuarioDTO usuarioDTO) {
        return validaciones
                .verificarExistenciaUsuarioMongoYFirebaseParaCrearUsuario(usuarioDTO)
                .flatMap(error -> {
                    Firebase.finalizarFirebase();
                    return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT));
                })
                .switchIfEmpty(usuarioRepository.save(mapperUtils.mapperDTOaEntidadUsuario(null)
                        .apply(usuarioDTO))
                )
                .map(usuario -> {
                    Firebase.finalizarFirebase();
                    return mapperUtils.mapperEntidadUsuarioaDTO().apply((Usuario) usuario);
                });
    }
}
