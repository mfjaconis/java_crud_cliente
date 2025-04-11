package br.com.mfjaconis.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.mfjaconis.domain.Cliente;

public class ClienteSetDAO implements IClienteDAO {

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public boolean excluir(Long cpf) {
        Cliente clienteEncontrato = null;
        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrato = cliente;
                break;
            }
        }

        if (clienteEncontrato != null) {
            this.set.remove(clienteEncontrato);
            return true;
        }
        return false;
    }

    @Override
    public boolean alterar(Cliente cliente) {
        Cliente clienteEncontrado = this.set.stream()
                .filter(c -> c.getCpf().equals(cliente.getCpf()))
                .findFirst()
                .orElse(null);

        if (clienteEncontrado != null) {
            clienteEncontrado.setNome(cliente.getNome());
            clienteEncontrado.setTel(cliente.getTel());
            clienteEncontrado.setNumero(cliente.getNumero());
            clienteEncontrado.setEnd(cliente.getEnd());
            clienteEncontrado.setCidade(cliente.getCidade());
            clienteEncontrado.setEstado(cliente.getEstado());
            return true;
        }
        return false;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.set.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }

}
