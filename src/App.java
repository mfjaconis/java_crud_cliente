import javax.swing.JOptionPane;

import br.com.mfjaconis.dao.ClienteMapDAO;
import br.com.mfjaconis.dao.IClienteDAO;
import br.com.mfjaconis.domain.Cliente;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = obterOpcaoUsuario();

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida. Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Menu", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente", "Consultar", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente para exclusão", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente para alteração", "Alterar", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }

            opcao = obterOpcaoUsuario();
        }
    }

    private static String obterOpcaoUsuario() {
        return JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Menu", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente, "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
                dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
        boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(String dados) {
        long cpf = Long.parseLong(dados);

        boolean clienteExcluido = iClienteDAO.excluir(cpf);

        if (clienteExcluido) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para exclusão", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar(String dados) {
        long cpf = Long.parseLong(dados);
        Cliente clienteExistente = iClienteDAO.consultar(cpf);

        if (clienteExistente != null) {
            String dadosAlterados = JOptionPane.showInputDialog(null,
                    "Digite os novos dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                    "Alterar", JOptionPane.INFORMATION_MESSAGE);
            String[] dadosSeparados = dadosAlterados.split(",");
            Cliente clienteAlterado = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                    dadosSeparados[3],
                    dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            boolean alterado = iClienteDAO.alterar(clienteAlterado);
            if (alterado) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao alterar cliente", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para alteração", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isExcluir(String opcao) {
        return "3".equals(opcao);
    }

    private static boolean isAlterar(String opcao) {
        return "4".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }
}
