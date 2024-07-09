package interfacee;

import modelo.persona;

import java.util.List;

public interface personaInter {
    persona findById(int id);
    List<persona> findAll();
    void save(persona persona);
    void update(persona persona);
    void delete(persona persona);
}
