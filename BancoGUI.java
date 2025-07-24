import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BancoGUI extends JFrame {
    private Conta conta;
    private JTextField nomeField;
    private JComboBox<String> tipoBox;
    private JLabel saldoLabel;
    private JTextField valorField;
    private JButton criarContaBtn, depositarBtn, sacarBtn, exibirSaldoBtn, voltarBtn;
    private JPanel painelConta, painelOperacoes;

    public BancoGUI() {
        setTitle("Banco Simples");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        painelConta = new JPanel(new GridLayout(0, 1, 5, 5));
        painelOperacoes = new JPanel(new GridLayout(0, 1, 5, 5));

        // Painel para login/criação de conta
        nomeField = new JTextField();
        tipoBox = new JComboBox<>(new String[]{"Conta Corrente", "Conta Poupança"});
        criarContaBtn = new JButton("Entrar/Criar Conta");

        painelConta.add(new JLabel("Nome da Conta:"));
        painelConta.add(nomeField);
        painelConta.add(new JLabel("Tipo de Conta:"));
        painelConta.add(tipoBox);
        painelConta.add(criarContaBtn);

        add(painelConta, BorderLayout.CENTER);

        criarContaBtn.addActionListener(e -> perguntarConta());

        // Painel de operações (inicialmente oculto)
        saldoLabel = new JLabel("Saldo: R$ 0.00");
        valorField = new JTextField();
        depositarBtn = new JButton("Depositar");
        sacarBtn = new JButton("Sacar");
        exibirSaldoBtn = new JButton("Exibir Saldo");
        voltarBtn = new JButton("Voltar");

        painelOperacoes.add(new JLabel("Valor:"));
        painelOperacoes.add(valorField);
        painelOperacoes.add(depositarBtn);
        painelOperacoes.add(sacarBtn);
        painelOperacoes.add(exibirSaldoBtn);
        painelOperacoes.add(saldoLabel);
        painelOperacoes.add(voltarBtn);

        depositarBtn.addActionListener(e -> depositar());
        sacarBtn.addActionListener(e -> sacar());
        exibirSaldoBtn.addActionListener(e -> exibirSaldo());
        voltarBtn.addActionListener(e -> voltarParaLogin());

        setVisible(true);
    }

    private void perguntarConta() {
        String[] opcoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Você já possui uma conta criada?",
                "Conta Existente",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        String nome = nomeField.getText().trim();
        String tipo = (String) tipoBox.getSelectedItem();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome da conta.");
            return;
        }

        if (resposta == JOptionPane.YES_OPTION) {
            // Simula buscar conta existente
            conta = Conta.getConta(nome);
            saldoLabel.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            JOptionPane.showMessageDialog(this, "Conta carregada! (Simulação)");
        } else {
            conta = new Conta(nome, tipo);
            saldoLabel.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
        }
        // Troca para painel de operações
        getContentPane().removeAll();
        add(painelOperacoes, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void voltarParaLogin() {
        // Limpa campos de valor e saldo
        valorField.setText("");
        saldoLabel.setText("Saldo: R$ 0.00");
        conta = null;
        // Troca para painel de login/criação
        getContentPane().removeAll();
        add(painelConta, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void depositar() {
        if (conta == null) {
            JOptionPane.showMessageDialog(this, "Crie ou carregue uma conta primeiro.");
            return;
        }
        try {
            double valor = Double.parseDouble(valorField.getText());
            if (valor <= 0) throw new NumberFormatException();
            conta.depositar(valor);
            saldoLabel.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            JOptionPane.showMessageDialog(this, "Depósito realizado!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void sacar() {
        if (conta == null) {
            JOptionPane.showMessageDialog(this, "Crie ou carregue uma conta primeiro.");
            return;
        }
        try {
            double valor = Double.parseDouble(valorField.getText());
            if (valor <= 0) throw new NumberFormatException();
            if (conta.sacar(valor)) {
                saldoLabel.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
                JOptionPane.showMessageDialog(this, "Saque realizado!");
            } else {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
        }
    }

    private void exibirSaldo() {
        if (conta == null) {
            JOptionPane.showMessageDialog(this, "Crie ou carregue uma conta primeiro.");
            return;
        }
        saldoLabel.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        JOptionPane.showMessageDialog(this, "Saldo atual: R$ " + String.format("%.2f", conta.getSaldo()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BancoGUI::new);
    }
} 