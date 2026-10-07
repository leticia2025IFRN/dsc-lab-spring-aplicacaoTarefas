package br.edu.ifrn.demo.repository;

import br.edu.ifrn.demo.model.Tarefa;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.function.Function;

@Repository
public class InMemoryTarefaRepository implements TarefaRepository {
    private final Map<Long, Tarefa> banco = new LinkedHashMap<>();

//    public Tarefa salvarTarefa(Tarefa tarefa) {
//        System.out.println("[REPOSITORY] Salvando tarefa em memória: " + tarefa.getTitulo());
//        banco.put(tarefa.getId(), tarefa);
//        return tarefa;
//    }
//
//    public List<Tarefa> listarTodasTarefas() {
//        System.out.println("[REPOSITORY] Buscando todas as tarefas em memória");
//        return new ArrayList<>(banco.values());
//    }
//
//    public Optional<Tarefa> buscarTarefaPorId(Long id) {
//        System.out.println("[REPOSITORY] Buscando tarefa por id: " + id);
//        return Optional.ofNullable(banco.get(id));
//    }
//
//    public boolean deletarTarefa(Long id) {
//        System.out.println("[REPOSITORY] Removendo a tarefa do banco");
//        return banco.remove(id) != null;
//    }

    // Implementação do JPARepository
    @Override
    public boolean deleteTarefaById(Long id) {
        System.out.println("[REPOSITORY] Removendo a tarefa do banco");
        return banco.remove(id) != null;
    }

    @Override
    public List<Tarefa> id(Long id) {
        return List.of();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Tarefa> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Tarefa> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Tarefa> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Tarefa getOne(Long aLong) {
        return null;
    }

    @Override
    public Tarefa getById(Long aLong) {
        return null;
    }

    @Override
    public Tarefa getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Tarefa> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tarefa> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Tarefa> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Tarefa> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tarefa> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tarefa> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Tarefa, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Tarefa> S save(S entity) {
        System.out.println("[REPOSITORY] Salvando tarefa em memória: " + entity.getTitulo());
        banco.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends Tarefa> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Tarefa> findById(Long aLong) {
        System.out.println("[REPOSITORY] Buscando tarefa por id: " + aLong);
        return Optional.ofNullable(banco.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Tarefa> findAll() {
        return List.of();
    }

    @Override
    public List<Tarefa> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Tarefa entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tarefa> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Tarefa> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Tarefa> findAll(Pageable pageable) {
        return null;
    }
}
