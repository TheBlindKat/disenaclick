package com.disenaclick.disenaclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.disenaclick.disenaclick.model.Usuario;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
            SELECT u, u.rol.nombreRol, u.plantilla.nombrePlantilla FROM Usuario u
            """)
    List<Object[]> findRolPlantilla();

    List<Usuario> findByNombres(String nombres);

    Usuario findByCorreo(String correo);

    List<Usuario> findByNombresAndApellidos(String nombres, String apellidos);

    Usuario findById(Integer id);

    /*
     * List<Usuario> findByCorreo(String correo);
     * 
     * Usuario findBy
     */

}
