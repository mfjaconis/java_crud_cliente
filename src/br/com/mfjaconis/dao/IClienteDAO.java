package br.com.mfjaconis.dao;

import java.util.Collection;

import br.com.mfjaconis.domain.Cliente;

public interface IClienteDAO {
    public Boolean cadastrar(Cliente cliente);

    public boolean excluir(Long cpf);

    public boolean alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}