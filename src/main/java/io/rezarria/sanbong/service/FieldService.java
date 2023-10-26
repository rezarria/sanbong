package io.rezarria.sanbong.service;

import io.rezarria.sanbong.model.Field;
import io.rezarria.sanbong.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository repository;

    public Field create(String name, String picture, String description) throws IllegalArgumentException {
        return repository.save(Field.builder().name(name).description(description).picture(picture).build());
    }

    public List<Field> getAll() {
        return repository.findAll();
    }

    public Iterable<Field> createMany(Iterable<Field> fields) {
        return repository.saveAll(fields);
    }

    public Field get(UUID id) {
        return repository.getReferenceById(id);
    }

    public List<Field> getMany(Collection<UUID> ids) {
        return repository.findAllById(ids);
    }

    public List<Field> getManyByName(Collection<String> names) {
        return repository.findAllByNameIn(names);
    }

    public void remove(UUID id) throws IllegalArgumentException {
        repository.deleteById(id);
    }

    public void remove(String name) throws IllegalArgumentException {
        repository.deleteByName(name);
    }

    public void remove(Collection<String> names) {
        repository.deleteAllByNameIn(names);
    }

    public void update(Field field) {
        repository.save(field);
    }
}
