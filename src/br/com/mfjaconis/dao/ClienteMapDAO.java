package br.com.mfjaconis.dao;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import br.com.mfjaconis.domain.Cliente;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }

        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public boolean excluir(Long cpf) {
        if (map.containsKey(cpf)) {
            map.remove(cpf);
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            System.out.println("Alterando cliente com CPF: " + cliente.getCpf());
            Cliente clienteCadastrado = map.get(cliente.getCpf());
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
            return true;
        } else {
            System.out.println("Cliente com CPF: " + cliente.getCpf() + " não encontrado.");
        }
        return false;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return map.values();
    }
}
